package service;

import java.util.HashMap;

public class FlightStatusService {

    private HashMap<String, String> status;

    public FlightStatusService() {

        status = new HashMap<>();
    }

    public void updateStatus(String flightNumber,
                             String newStatus) {

        status.put(
                flightNumber.toUpperCase(),
                newStatus);

        System.out.println(
                "Flight status updated successfully.");
    }

    public void displayStatus(String flightNumber) {

        String currentStatus =
                status.get(flightNumber.toUpperCase());

        if (currentStatus == null) {

            System.out.println(
                    "No status available for this flight.");

            return;
        }

        System.out.println(
                "Flight " + flightNumber +
                " Status: " + currentStatus);
    }

    public void displayAllStatuses() {

        if (status.isEmpty()) {
            System.out.println("No flight status available.");
            return;
        }

        System.out.println("\n===== REAL-TIME FLIGHT STATUS =====");

        for (String flight : status.keySet()) {

            System.out.println(
                    flight + " : " +
                    status.get(flight));
        }
    }
}