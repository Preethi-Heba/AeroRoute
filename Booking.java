package model;

public class Booking {

    private String pnr;
    private String username;
    private String flightNumber;
    private String passengerName;
    private String seat;

    public Booking(String pnr,
                   String username,
                   String flightNumber,
                   String passengerName,
                   String seat) {

        this.pnr = pnr;
        this.username = username;
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
        this.seat = seat;
    }

    public String getPnr() {
        return pnr;
    }

    public String getUsername() {
        return username;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getSeat() {
        return seat;
    }

    @Override
    public String toString() {

        return "\nPNR: " + pnr +
                "\nPassenger: " + passengerName +
                "\nFlight: " + flightNumber +
                "\nSeat: " + seat;
    }
}