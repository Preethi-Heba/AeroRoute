package model;

public class FlightSchedule {

    private String flightNumber;
    private String departureTime;
    private String arrivalTime;
    private String status;

    public FlightSchedule(String flightNumber,
                          String departureTime,
                          String arrivalTime) {

        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = "On Time";
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Flight: " + flightNumber +
                " | Departure: " + departureTime +
                " | Arrival: " + arrivalTime +
                " | Status: " + status;
    }
}