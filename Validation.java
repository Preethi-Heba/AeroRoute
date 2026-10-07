package util;

public class Validation {

    // =========================================================
    // AIRPORT CODE VALIDATION
    // =========================================================

    public static boolean validAirportCode(String code) {

        if (code == null) {
            return false;
        }

        return code.matches("[A-Za-z]{3}");
    }

    // =========================================================
    // FARE VALIDATION
    // =========================================================

    public static boolean validFare(double fare) {

        return fare > 0;
    }

    // =========================================================
    // DURATION VALIDATION
    // =========================================================

    public static boolean validDuration(double duration) {

        return duration > 0;
    }
}