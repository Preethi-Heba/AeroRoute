package model;

public class Flight {

    private String flightNumber;
    private String sourceAirport;
    private String destinationAirport;
    private double fare;
    private double duration;

    // Default Constructor
    public Flight() {
    }

    // Parameterized Constructor
    public Flight(String flightNumber,
                  String sourceAirport,
                  String destinationAirport,
                  double fare,
                  double duration) {

        this.flightNumber = flightNumber;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.fare = fare;
        this.duration = duration;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public double getFare() {
        return fare;
    }

    public double getDuration() {
        return duration;
    }

    // Setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {

        return "\nFlight Number      : " + flightNumber +
                "\nSource Airport     : " + sourceAirport +
                "\nDestination        : " + destinationAirport +
                "\nFare               : ₹" + fare +
                "\nDuration           : " + duration + " hrs";
    }
}