package com.navigo;

import java.util.Random;

class QRTicket {
    String details;
    String ticketId;

    public QRTicket(String details) {
        this.details = details;
        this.ticketId = "TKT" + new Random().nextInt(1000000);
    }

    public void generateQR() {
        System.out.println("\n✅ Payment Successful! Have a great journey! 🚀");
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Details: " + details);
    }
}

