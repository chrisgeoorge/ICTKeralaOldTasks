package com.navigo;

abstract class TransportMode {
    String name;
    double farePerMile;
    double speed; // in mph

    public TransportMode(String name, double farePerMile, double speed) {
        this.name = name;
        this.farePerMile = farePerMile;
        this.speed = speed;
    }

    public abstract double calculateFare(double distance);
    public abstract double calculateTime(double distance);
}

// Concrete transport classes
class Bus extends TransportMode {
    public Bus() {
        super("Bus", 1.5, 25);
    }

    public double calculateFare(double distance) {
        return farePerMile * distance;
    }

    public double calculateTime(double distance) {
        return distance / speed;
    }
}

class Metro extends TransportMode {
    public Metro() {
        super("Metro", 2.0, 35);
    }

    public double calculateFare(double distance) {
        return farePerMile * distance;
    }

    public double calculateTime(double distance) {
        return distance / speed;
    }
}

class Cab extends TransportMode {
    public Cab() {
        super("Cab", 3.0, 40);
    }

    public double calculateFare(double distance) {
        return farePerMile * distance + 5; // base fare
    }

    public double calculateTime(double distance) {
        return distance / speed;
    }
}

class Walking extends TransportMode {
    public Walking() {
        super("Walking", 0, 3);
    }

    public double calculateFare(double distance) {
        return 0; // Free
    }

    public double calculateTime(double distance) {
        return distance / speed;
    }
}
