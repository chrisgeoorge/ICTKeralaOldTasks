package com.navigo;

import java.util.*;

class RouteOption {
    List<TransportMode> modes;
    List<Double> distances;
    double totalFare;
    double totalTime;
    double totalDistance;
    String ticketId;
    int currentSegment = 0;

    public RouteOption(List<TransportMode> modes, List<Double> distances) {
        this.modes = modes;
        this.distances = distances;
        this.totalFare = 0;
        this.totalTime = 0;
        this.totalDistance = 0;
        this.ticketId = "TKT" + new Random().nextInt(1000000);

        for (int i = 0; i < modes.size(); i++) {
            this.totalFare += modes.get(i).calculateFare(distances.get(i));
            this.totalTime += modes.get(i).calculateTime(distances.get(i));
            this.totalDistance += distances.get(i);
        }
        this.totalFare = Math.round(this.totalFare * 100.0) / 100.0; // Round to 2 decimal places
    }

    public void displayRoute(int index) {
        System.out.print(index + ". ");
        for (int i = 0; i < modes.size(); i++) {
            System.out.print(modes.get(i).name);
            if (i < modes.size() - 1) System.out.print(" → ");
        }
        System.out.println(" | ₹" + totalFare + " | " + (int) (totalTime * 60) + " mins");
    }

    public boolean trackJourney() {
        if (currentSegment < modes.size()) {
            System.out.println("Currently on: " + modes.get(currentSegment).name);
            double remainingTime = 0;
            for (int i = currentSegment; i < modes.size(); i++) {
                remainingTime += modes.get(i).calculateTime(distances.get(i));
            }
            System.out.println("Remaining Time: " + (int) (remainingTime * 60) + " mins");
            currentSegment++;
            return true;
        } else {
            System.out.println("Journey completed!\nThank you for choosing Navigo!");
            return false;
        }
    }
}