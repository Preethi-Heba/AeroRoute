package service;

import model.Booking;
import java.util.ArrayList;

public class BookingService {

    private ArrayList<Booking> bookings;

    public BookingService() {
        bookings = new ArrayList<>();
    }

    public void bookTicket(String username,
                           String flightNumber,
                           String passengerName,
                           String seat) {

        String pnr = "AR" + (1000 + bookings.size() + 1);

        Booking booking = new Booking(
                pnr,
                username,
                flightNumber,
                passengerName,
                seat);

        bookings.add(booking);

        System.out.println("\n===== TICKET BOOKED =====");
        System.out.println("PNR: " + pnr);
        System.out.println("Passenger: " + passengerName);
        System.out.println("Flight: " + flightNumber);
        System.out.println("Seat: " + seat);
        System.out.println("Booking successful!");
    }

    public void displayBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.println("\n===== BOOKINGS =====");

        for (Booking booking : bookings) {
            System.out.println(booking);
            System.out.println("--------------------");
        }
    }
}