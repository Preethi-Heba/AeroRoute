package menu;

import model.Airport;
import model.Flight;

import service.RouteService;
import service.UserService;
import service.BookingService;
import service.FlightScheduleService;
import service.FlightStatusService;

import util.Validation;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    private RouteService service;
    private UserService userService;

    // New services
    private BookingService bookingService;
    private FlightScheduleService scheduleService;
    private FlightStatusService statusService;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Menu() {

        scanner = new Scanner(System.in);

        service = new RouteService();
        userService = new UserService();

        // New services
        bookingService = new BookingService();
        scheduleService = new FlightScheduleService();
        statusService = new FlightStatusService();
    }

    // =========================================================
    // START
    // =========================================================

    public void start() {

        System.out.println(
                "======================================");

        System.out.println(
                "        WELCOME TO AEROROUTE");

        System.out.println(
                "   Flight Scheduling & Route System");

        System.out.println(
                "======================================");

        while (true) {

            System.out.println("\n===== USER MENU =====");

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    register();
                    break;

                case "2":

                    if (login()) {
                        mainMenu();
                    }

                    break;

                case "3":

                    System.out.println(
                            "Thank you for using AeroRoute!");

                    return;

                default:

                    System.out.println(
                            "Invalid choice.");
            }
        }
    }

    // =========================================================
    // REGISTER
    // =========================================================

    private void register() {

        System.out.println(
                "\n===== REGISTER =====");

        System.out.print(
                "Enter username: ");

        String username = scanner.nextLine();

        System.out.print(
                "Enter password: ");

        String password = scanner.nextLine();

        userService.register(
                username,
                password);
    }

    // =========================================================
    // LOGIN
    // =========================================================

    private boolean login() {

        System.out.println(
                "\n===== LOGIN =====");

        System.out.print(
                "Enter username: ");

        String username = scanner.nextLine();

        System.out.print(
                "Enter password: ");

        String password = scanner.nextLine();

        boolean success =
                userService.login(
                        username,
                        password);

        if (success) {

            System.out.println(
                    "Login successful.");

        } else {

            System.out.println(
                    "Invalid username or password.");
        }

        return success;
    }

    // =========================================================
    // MAIN MENU
    // =========================================================

    private void mainMenu() {

        while (true) {

            System.out.println(
                    "\n===== AEROROUTE MAIN MENU =====");

            System.out.println("1. Add Airport");
            System.out.println("2. Add Flight");
            System.out.println("3. Display Airports");
            System.out.println("4. Display Flights");
            System.out.println("5. Search Airport");
            System.out.println("6. Delete Airport");
            System.out.println("7. Delete Flight");
            System.out.println("8. Display Graph");

            System.out.println("9. Find Route using BFS");
            System.out.println("10. Find Route using DFS");
            System.out.println("11. Find Cheapest Route");
            System.out.println("12. Find Fastest Route");

            // New features
            System.out.println("13. Add Flight Schedule");
            System.out.println("14. View Flight Schedule");
            System.out.println("15. Update Flight Status");
            System.out.println("16. Book Ticket");

            System.out.println("17. View Bookings");

            System.out.println("18. Logout");

            System.out.print(
                    "Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                // =================================================
                // AIRPORT
                // =================================================

                case "1":
                    addAirport();
                    break;

                // =================================================
                // FLIGHT
                // =================================================

                case "2":
                    addFlight();
                    break;

                // =================================================
                // DISPLAY AIRPORTS
                // =================================================

                case "3":

                    service.displayAirports();

                    break;

                // =================================================
                // DISPLAY FLIGHTS
                // =================================================

                case "4":

                    service.displayFlights();

                    break;

                // =================================================
                // SEARCH AIRPORT
                // =================================================

                case "5":

                    searchAirport();

                    break;

                // =================================================
                // DELETE AIRPORT
                // =================================================

                case "6":

                    deleteAirport();

                    break;

                // =================================================
                // DELETE FLIGHT
                // =================================================

                case "7":

                    deleteFlight();

                    break;

                // =================================================
                // DISPLAY GRAPH
                // =================================================

                case "8":

                    service.displayGraph();

                    break;

                // =================================================
                // BFS
                // =================================================

                case "9":

                    findRouteBFS();

                    break;

                // =================================================
                // DFS
                // =================================================

                case "10":

                    findRouteDFS();

                    break;

                // =================================================
                // CHEAPEST ROUTE
                // =================================================

                case "11":

                    findCheapestRoute();

                    break;

                // =================================================
                // FASTEST ROUTE
                // =================================================

                case "12":

                    findFastestRoute();

                    break;

                // =================================================
                // ADD FLIGHT SCHEDULE
                // =================================================

                case "13":

                    addFlightSchedule();

                    break;

                // =================================================
                // VIEW FLIGHT SCHEDULE
                // =================================================

                case "14":

                    viewFlightSchedule();

                    break;

                // =================================================
                // UPDATE FLIGHT STATUS
                // =================================================

                case "15":

                    updateFlightStatus();

                    break;

                // =================================================
                // BOOK TICKET
                // =================================================

                case "16":

                    bookTicket();

                    break;

                // =================================================
                // VIEW BOOKINGS
                // =================================================

                case "17":

                    viewBookings();

                    break;

                // =================================================
                // LOGOUT
                // =================================================

                case "18":

                    System.out.println(
                            "Logged out successfully.");

                    return;

                // =================================================
                // INVALID
                // =================================================

                default:

                    System.out.println(
                            "Invalid choice.");
            }
        }
    }

    // =========================================================
    // ADD AIRPORT
    // =========================================================

    private void addAirport() {

        System.out.println(
                "\n===== ADD AIRPORT =====");

        System.out.print(
                "Enter Airport Code: ");

        String code = scanner.nextLine();

        // Validation
        if (!Validation.validAirportCode(code)) {

            System.out.println(
                    "Airport code must contain exactly 3 letters.");

            return;
        }

        code = code.toUpperCase();

        System.out.print(
                "Enter Airport Name: ");

        String name = scanner.nextLine();

        System.out.print(
                "Enter City: ");

        String city = scanner.nextLine();

        System.out.print(
                "Enter Country: ");

        String country = scanner.nextLine();

        Airport airport =
                new Airport(
                        code,
                        name,
                        city,
                        country);

        service.addAirport(airport);
    }

    // =========================================================
    // ADD FLIGHT
    // =========================================================

    private void addFlight() {

        System.out.println(
                "\n===== ADD FLIGHT =====");

        System.out.print(
                "Enter Flight Number: ");

        String flightNumber =
                scanner.nextLine();

        System.out.print(
                "Enter Source Airport: ");

        String source =
                scanner.nextLine().toUpperCase();

        System.out.print(
                "Enter Destination Airport: ");

        String destination =
                scanner.nextLine().toUpperCase();

        // =====================================================
        // FARE
        // =====================================================

        System.out.print(
                "Enter Fare: ");

        String fareInput =
                scanner.nextLine();

        double fare;

        try {

            fare =
                    Double.parseDouble(fareInput);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid fare.");

            return;
        }

        if (!Validation.validFare(fare)) {

            System.out.println(
                    "Fare must be greater than 0.");

            return;
        }

        // =====================================================
        // DURATION
        // =====================================================

        System.out.print(
                "Enter Duration in hours: ");

        String durationInput =
                scanner.nextLine();

        double duration;

        try {

            duration =
                    Double.parseDouble(durationInput);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid duration.");

            return;
        }

        if (!Validation.validDuration(duration)) {

            System.out.println(
                    "Duration must be greater than 0.");

            return;
        }

        Flight flight =
                new Flight(
                        flightNumber,
                        source,
                        destination,
                        fare,
                        duration);

        service.addFlight(flight);
    }

    // =========================================================
    // SEARCH AIRPORT
    // =========================================================

    private void searchAirport() {

        System.out.println(
                "\n===== SEARCH AIRPORT =====");

        System.out.print(
                "Enter Airport Code: ");

        String code =
                scanner.nextLine();

        service.searchAirport(code);
    }

    // =========================================================
    // DELETE AIRPORT
    // =========================================================

    private void deleteAirport() {

        System.out.println(
                "\n===== DELETE AIRPORT =====");

        System.out.print(
                "Enter Airport Code: ");

        String code =
                scanner.nextLine();

        service.deleteAirport(code);
    }

    // =========================================================
    // DELETE FLIGHT
    // =========================================================

    private void deleteFlight() {

        System.out.println(
                "\n===== DELETE FLIGHT =====");

        System.out.print(
                "Enter Flight Number: ");

        String flightNumber =
                scanner.nextLine();

        service.deleteFlight(
                flightNumber);
    }

    // =========================================================
    // BFS
    // =========================================================

    private void findRouteBFS() {

        System.out.println(
                "\n===== BFS ROUTE SEARCH =====");

        System.out.print(
                "Enter Source Airport: ");

        String source =
                scanner.nextLine();

        System.out.print(
                "Enter Destination Airport: ");

        String destination =
                scanner.nextLine();

        service.findRouteBFS(
                source,
                destination);
    }

    // =========================================================
    // DFS
    // =========================================================

    private void findRouteDFS() {

        System.out.println(
                "\n===== DFS ROUTE SEARCH =====");

        System.out.print(
                "Enter Source Airport: ");

        String source =
                scanner.nextLine();

        System.out.print(
                "Enter Destination Airport: ");

        String destination =
                scanner.nextLine();

        service.findRouteDFS(
                source,
                destination);
    }

    // =========================================================
    // CHEAPEST ROUTE
    // =========================================================

    private void findCheapestRoute() {

        System.out.println(
                "\n===== CHEAPEST ROUTE SEARCH =====");

        System.out.print(
                "Enter Source Airport: ");

        String source =
                scanner.nextLine();

        System.out.print(
                "Enter Destination Airport: ");

        String destination =
                scanner.nextLine();

        service.findCheapestRoute(
                source,
                destination);
    }

    // =========================================================
    // FASTEST ROUTE
    // =========================================================

    private void findFastestRoute() {

        System.out.println(
                "\n===== FASTEST ROUTE SEARCH =====");

        System.out.print(
                "Enter Source Airport: ");

        String source =
                scanner.nextLine();

        System.out.print(
                "Enter Destination Airport: ");

        String destination =
                scanner.nextLine();

        service.findFastestRoute(
                source,
                destination);
    }

    // =========================================================
    // ADD FLIGHT SCHEDULE
    // =========================================================

    private void addFlightSchedule() {

        System.out.println(
                "\n===== ADD FLIGHT SCHEDULE =====");

        System.out.print(
                "Enter Flight Number: ");

        String flightNumber =
                scanner.nextLine();

        System.out.print(
                "Enter Departure Time: ");

        String departureTime =
                scanner.nextLine();

        System.out.print(
                "Enter Arrival Time: ");

        String arrivalTime =
                scanner.nextLine();

        scheduleService.addSchedule(
                flightNumber,
                departureTime,
                arrivalTime);
    }

    // =========================================================
    // VIEW FLIGHT SCHEDULE
    // =========================================================

    private void viewFlightSchedule() {

        scheduleService.displaySchedules();
    }

    // =========================================================
    // UPDATE FLIGHT STATUS
    // =========================================================

    private void updateFlightStatus() {

        System.out.println(
                "\n===== UPDATE FLIGHT STATUS =====");

        System.out.print(
                "Enter Flight Number: ");

        String flightNumber =
                scanner.nextLine();

        System.out.println(
                "\nAvailable Status:");

        System.out.println("1. On Time");
        System.out.println("2. Delayed");
        System.out.println("3. Cancelled");

        System.out.print(
                "Choose status: ");

        String choice =
                scanner.nextLine();

        String status;

        switch (choice) {

            case "1":
                status = "On Time";
                break;

            case "2":
                status = "Delayed";
                break;

            case "3":
                status = "Cancelled";
                break;

            default:

                System.out.println(
                        "Invalid status.");

                return;
        }

        statusService.updateStatus(
                flightNumber,
                status);
    }

    // =========================================================
    // BOOK TICKET
    // =========================================================

    private void bookTicket() {

        System.out.println(
                "\n===== BOOK TICKET =====");

        System.out.print(
                "Enter Flight Number: ");

        String flightNumber =
                scanner.nextLine();

        System.out.print(
                "Enter Passenger Name: ");

        String passengerName =
                scanner.nextLine();

        System.out.print(
                "Enter Seat Number: ");

        String seat =
                scanner.nextLine();

        bookingService.bookTicket(
                "admin",
                flightNumber,
                passengerName,
                seat);
    }

    // =========================================================
    // VIEW BOOKINGS
    // =========================================================

    private void viewBookings() {

        bookingService.displayBookings();
    }
}