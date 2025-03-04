package com.navigo;

import java.util.*;

public class NavigoMain {
    static List<String> cities = Arrays.asList("New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio");
    static Random rand = new Random();
    static Map<String, RouteOption> activeTickets = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Start Journey");
            System.out.println("2. Track Journey");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    startJourney(scanner);
                    break;
                case 2:
                    trackJourney(scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void startJourney(Scanner scanner) {
        System.out.println("\nAvailable cities: " + cities);
        System.out.print("Enter starting city: ");
        String from = scanner.nextLine();
        System.out.print("Enter destination city: ");
        String to = scanner.nextLine();
        if (!cities.contains(from) || !cities.contains(to)) {
            System.out.println("Invalid city selection.");
            return;
        }

        double totalDistance = 10 + rand.nextDouble() * 30;
        List<TransportMode> modes = Arrays.asList(new Bus(), new Metro(), new Cab());
        List<RouteOption> options = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            List<TransportMode> selectedModes = new ArrayList<>();
            List<Double> distances = new ArrayList<>();
            double remainingDistance = totalDistance;
            TransportMode lastMode = null;
            while (remainingDistance > 0) {
                TransportMode mode;
                do {
                    mode = modes.get(rand.nextInt(modes.size()));
                } while (lastMode instanceof Cab && mode instanceof Cab);
                double segment = Math.min(remainingDistance, 5 + rand.nextDouble() * 10);
                selectedModes.add(mode);
                distances.add(segment);
                remainingDistance -= segment;
                lastMode = mode;
            }
            options.add(new RouteOption(selectedModes, distances));
        }

        System.out.println("\nAvailable Transport Combinations:");
        for (int i = 0; i < options.size(); i++) {
            options.get(i).displayRoute(i + 1);
        }

        System.out.print("\nEnter your preferred option: ");
        int choice = scanner.nextInt();
        if (choice < 1 || choice > 4) {
            System.out.println("Invalid choice.");
            return;
        }

        RouteOption selectedRoute = options.get(choice - 1);

        // Display fare and time before proceeding to payment
        double fare = selectedRoute.totalFare;
        double time = selectedRoute.totalTime * 60;  // Convert hours to minutes
        System.out.println("\nTransport Mode: " + selectedRoute.modes.get(0).name + " → " + selectedRoute.modes.get(1).name);
        System.out.println("Fare: ₹" + fare);
        System.out.println("Estimated Time: " + (int) time + " mins");

        // Prompt user for payment
        System.out.print("\nProceed to Payment? (yes/no): ");
        scanner.nextLine(); // Consume leftover newline
        String paymentChoice = scanner.nextLine().toLowerCase();

        if (paymentChoice.equals("yes")) {
            System.out.println("\nProcessing Payment...");
            // Simulating payment processing
            try {
                Thread.sleep(2000); // Simulate payment processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Once payment is successful, generate the ticket ID
            String ticketId = "TKT" + new Random().nextInt(1000000);
            selectedRoute.ticketId = ticketId; // Assign the generated ticket ID

            activeTickets.put(ticketId, selectedRoute); // Save the route with the ticket ID
            System.out.println("✅ Payment Successful! Have a great journey! 🚀");
            System.out.println("Ticket ID: " + selectedRoute.ticketId);
        } else {
            System.out.println("Payment cancelled. Thank you for using the service.");
        }
    }

    public static void trackJourney(Scanner scanner) {
        System.out.print("Enter Ticket ID: ");
        String ticketId = scanner.nextLine();
        if (activeTickets.containsKey(ticketId)) {
            RouteOption route = activeTickets.get(ticketId);
            if (!route.trackJourney()) {
                activeTickets.remove(ticketId);
            }
        } else {
            System.out.println("Invalid Ticket ID.");
        }
    }
}

