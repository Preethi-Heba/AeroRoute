package model;

import java.util.ArrayList;
import java.util.List;

public class RouteResult {

    private ArrayList<Flight> flights;
    private double totalFare;
    private double totalDuration;

    public RouteResult(List<Flight> flights) {

        this.flights = new ArrayList<>(flights);

        totalFare = 0;
        totalDuration = 0;

        for (Flight flight : flights) {

            totalFare += flight.getFare();
            totalDuration += flight.getDuration();
        }
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getTotalDuration() {
        return totalDuration;
    }

    public int getNumberOfFlights() {
        return flights.size();
    }

    public int getNumberOfStops() {
        return Math.max(0, flights.size() - 1);
    }

    public void displayRoute() {

        if (flights.isEmpty()) {
            System.out.println("No flights in this route.");
            return;
        }

        System.out.println("\n===== ROUTE DETAILS =====");

        System.out.println(
                "Starting Airport: "
                        + flights.get(0)
                        .getSourceAirport()
                        .toUpperCase());

        for (int i = 0; i < flights.size(); i++) {

            Flight flight = flights.get(i);

            System.out.println(
                    "\nFlight " + (i + 1));

            System.out.println(
                    "Flight Number: "
                            + flight.getFlightNumber());

            System.out.println(
                    "Route: "
                            + flight.getSourceAirport().toUpperCase()
                            + " -> "
                            + flight.getDestinationAirport().toUpperCase());

            System.out.println(
                    "Fare: ₹"
                            + flight.getFare());

            System.out.println(
                    "Duration: "
                            + flight.getDuration()
                            + " hours");
        }

        System.out.println("\n===== ROUTE SUMMARY =====");

        System.out.println(
                "Total Fare: ₹"
                        + totalFare);

        System.out.println(
                "Total Duration: "
                        + totalDuration
                        + " hours");

        System.out.println(
                "Number of Flights: "
                        + getNumberOfFlights());

        System.out.println(
                "Number of Stops: "
                        + getNumberOfStops());
    }
}