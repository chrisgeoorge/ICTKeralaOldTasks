import java.util.Scanner;

public class SalesReportGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numProducts;
        while (true) {
            try {
                System.out.print("Enter the total number of products: ");
                numProducts = Integer.parseInt(scanner.nextLine());
                if (numProducts <= 0) {
                    System.out.println("Please enter a positive number of products.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        String[] productNames = new String[numProducts];
        double[] quantities = new double[numProducts];
        double[] prices = new double[numProducts];
        double totalSales = 0;
        double highestSales = Double.MIN_VALUE;
        int highestSellingProduct = -1;

        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter name for product " + (i + 1) + ": ");
            productNames[i] = scanner.nextLine();

            while (true) {
                try {
                    System.out.print("Enter price for " + productNames[i] + ": ");
                    prices[i] = Double.parseDouble(scanner.nextLine());
                    if (prices[i] < 0) {
                        System.out.println("Price cannot be negative. Please enter a valid amount.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a numeric value.");
                }
            }

            while (true) {
                try {
                    System.out.print("Enter quantity sold for " + productNames[i] + ": ");
                    quantities[i] = Double.parseDouble(scanner.nextLine());
                    if (quantities[i] < 0) {
                        System.out.println("Quantity cannot be negative. Please enter a valid amount.");
                    } else {
                        totalSales += prices[i] * quantities[i];
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a numeric value.");
                }
            }
        }

        for (int i = 0; i < numProducts; i++) {
            double productRevenue = prices[i] * quantities[i];
            if (i == 0 || productRevenue > highestSales) {
                highestSales = productRevenue;
                highestSellingProduct = i;
            }
        }

        double averageSales = totalSales / numProducts;

        System.out.println("\n===== SALES REPORT =====");
        System.out.println("Total Sales: $" + totalSales);
        System.out.println("Average Sales: $" + averageSales);
        System.out.println("Highest Selling Product: " + productNames[highestSellingProduct] + " with sales of $" + highestSales);

        System.out.println("\nSales Breakdown:");
        for (int i = 0; i < numProducts; i++) {
            System.out.println(productNames[i] + " - Price: $" + prices[i] + " | Quantity Sold: " + quantities[i] + " | Total Sales: $" + (prices[i] * quantities[i]));
        }

        scanner.close();
    }
}
