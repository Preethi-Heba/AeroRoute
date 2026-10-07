package service;

import model.FlightSchedule;
import java.util.ArrayList;

public class FlightScheduleService {

    private ArrayList<FlightSchedule> schedules;

    public FlightScheduleService() {
        schedules = new ArrayList<>();
    }

    public void addSchedule(String flightNumber,
                             String departureTime,
                             String arrivalTime) {

        for (FlightSchedule schedule : schedules) {

            if (schedule.getFlightNumber()
                    .equalsIgnoreCase(flightNumber)) {

                System.out.println("Schedule already exists.");
                return;
            }
        }

        schedules.add(
                new FlightSchedule(
                        flightNumber,
                        departureTime,
                        arrivalTime));

        System.out.println("Flight schedule added successfully.");
    }

    public void displaySchedules() {

        if (schedules.isEmpty()) {
            System.out.println("No flight schedules available.");
            return;
        }

        System.out.println("\n===== FLIGHT SCHEDULE =====");

        for (FlightSchedule schedule : schedules) {
            System.out.println(schedule);
        }
    }

    public void updateStatus(String flightNumber,
                             String status) {

        for (FlightSchedule schedule : schedules) {

            if (schedule.getFlightNumber()
                    .equalsIgnoreCase(flightNumber)) {

                schedule.setStatus(status);

                System.out.println(
                        "Flight status updated successfully.");

                return;
            }
        }

        System.out.println("Flight schedule not found.");
    }
}