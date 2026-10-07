package graph;

import model.Airport;
import model.Flight;
import model.RouteResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FlightGraph {

    private HashMap<String, Airport> airports;
    private HashMap<String, ArrayList<Flight>> graph;

    public FlightGraph() {

        airports = new HashMap<>();
        graph = new HashMap<>();
    }

    // =========================================================
    // ADD AIRPORT
    // =========================================================

    public void addAirport(Airport airport) {

        String code =
                airport.getAirportCode().toUpperCase();

        if (airports.containsKey(code)) {

            System.out.println(
                    "Airport already exists.");

            return;
        }

        airports.put(code, airport);

        graph.put(
                code,
                new ArrayList<>());

        System.out.println(
                "Airport added successfully.");
    }

    // =========================================================
    // ADD FLIGHT
    // =========================================================

    public void addFlight(Flight flight) {

        String source =
                flight.getSourceAirport()
                        .toUpperCase();

        String destination =
                flight.getDestinationAirport()
                        .toUpperCase();

        if (!airports.containsKey(source)) {

            System.out.println(
                    "Source airport not found.");

            return;
        }

        if (!airports.containsKey(destination)) {

            System.out.println(
                    "Destination airport not found.");

            return;
        }

        graph.get(source).add(flight);

        System.out.println(
                "Flight added successfully.");
    }

    // =========================================================
    // DISPLAY AIRPORTS
    // =========================================================

    public void displayAirports() {

        if (airports.isEmpty()) {

            System.out.println(
                    "No airports available.");

            return;
        }

        System.out.println(
                "\n===== AIRPORTS =====");

        for (Airport airport :
                airports.values()) {

            System.out.println(airport);
        }
    }

    // =========================================================
    // DISPLAY FLIGHTS
    // =========================================================

    public void displayFlights() {

        boolean found = false;

        System.out.println(
                "\n===== FLIGHTS =====");

        for (Map.Entry<String,
                ArrayList<Flight>> entry :
                graph.entrySet()) {

            ArrayList<Flight> flights =
                    entry.getValue();

            for (Flight flight : flights) {

                System.out.println(flight);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No flights available.");
        }
    }

    // =========================================================
    // SEARCH AIRPORT
    // =========================================================

    public void searchAirport(String code) {

        code = code.toUpperCase();

        if (airports.containsKey(code)) {

            System.out.println(
                    "\nAirport Found:");

            System.out.println(
                    airports.get(code));

        } else {

            System.out.println(
                    "Airport not found.");
        }
    }

    // =========================================================
    // DELETE AIRPORT
    // =========================================================

    public void deleteAirport(String code) {

        String airportCode = code.toUpperCase();

        if (!airports.containsKey(airportCode)) {

            System.out.println(
                    "Airport not found.");

            return;
        }

        airports.remove(airportCode);

        graph.remove(airportCode);

        for (ArrayList<Flight> flights :
                graph.values()) {

            flights.removeIf(
                    flight ->
                            flight.getDestinationAirport()
                                    .equalsIgnoreCase(airportCode));
        }

        System.out.println(
                "Airport deleted successfully.");
    }

    // =========================================================
    // DELETE FLIGHT
    // =========================================================

    public void deleteFlight(
            String flightNumber) {

        for (ArrayList<Flight> flights :
                graph.values()) {

            for (int i = 0;
                 i < flights.size();
                 i++) {

                if (flights.get(i)
                        .getFlightNumber()
                        .equalsIgnoreCase(
                                flightNumber)) {

                    flights.remove(i);

                    System.out.println(
                            "Flight deleted successfully.");

                    return;
                }
            }
        }

        System.out.println(
                "Flight not found.");
    }

    // =========================================================
    // DISPLAY GRAPH
    // =========================================================

    public void displayGraph() {

        if (graph.isEmpty()) {

            System.out.println(
                    "Graph is empty.");

            return;
        }

        System.out.println(
                "\n===== FLIGHT GRAPH =====");

        for (Map.Entry<String,
                ArrayList<Flight>> entry :
                graph.entrySet()) {

            String source =
                    entry.getKey();

            System.out.print(
                    source + " -> ");

            ArrayList<Flight> flights =
                    entry.getValue();

            if (flights.isEmpty()) {

                System.out.println(
                        "No outgoing flights");

                continue;
            }

            for (Flight flight :
                    flights) {

                System.out.print(
                        flight.getDestinationAirport()
                                .toUpperCase()
                                + " ");
            }

            System.out.println();
        }
    }

    // =========================================================
    // BFS ROUTE
    // =========================================================

    public void findRouteBFS(
            String source,
            String destination) {

        source = source.toUpperCase();
        destination = destination.toUpperCase();

        if (!validateRoute(
                source,
                destination)) {

            return;
        }

        Queue<String> queue =
                new LinkedList<>();

        Set<String> visited =
                new HashSet<>();

        HashMap<String, String>
                parentAirport =
                new HashMap<>();

        HashMap<String, Flight>
                parentFlight =
                new HashMap<>();

        queue.add(source);

        visited.add(source);

        parentAirport.put(
                source,
                null);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current =
                    queue.poll();

            for (Flight flight :
                    graph.get(current)) {

                String next =
                        flight.getDestinationAirport()
                                .toUpperCase();

                if (!visited.contains(next)) {

                    visited.add(next);

                    parentAirport.put(
                            next,
                            current);

                    parentFlight.put(
                            next,
                            flight);

                    queue.add(next);

                    if (next.equals(
                            destination)) {

                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                break;
            }
        }

        if (!found) {

            System.out.println(
                    "\nNo route found from "
                            + source
                            + " to "
                            + destination
                            + ".");

            return;
        }

        ArrayList<Flight> routeFlights =
                new ArrayList<>();

        String current =
                destination;

        while (!current.equals(source)) {

            Flight flight =
                    parentFlight.get(current);

            routeFlights.add(
                    0,
                    flight);

            current =
                    parentAirport.get(current);
        }

        RouteResult result =
                new RouteResult(
                        routeFlights);

        System.out.println(
                "\n===== BFS ROUTE =====");

        result.displayRoute();
    }

    // =========================================================
    // DFS ROUTE
    // =========================================================

    public void findRouteDFS(
            String source,
            String destination) {

        source = source.toUpperCase();
        destination = destination.toUpperCase();

        if (!validateRoute(
                source,
                destination)) {

            return;
        }

        Set<String> visited =
                new HashSet<>();

        ArrayList<Flight> route =
                new ArrayList<>();

        boolean found =
                dfs(
                        source,
                        destination,
                        visited,
                        route);

        if (!found) {

            System.out.println(
                    "\nNo route found from "
                            + source
                            + " to "
                            + destination
                            + ".");

            return;
        }

        RouteResult result =
                new RouteResult(route);

        System.out.println(
                "\n===== DFS ROUTE =====");

        result.displayRoute();
    }

    // =========================================================
    // DFS HELPER
    // =========================================================

    private boolean dfs(
            String current,
            String destination,
            Set<String> visited,
            ArrayList<Flight> route) {

        visited.add(current);

        if (current.equals(destination)) {

            return true;
        }

        ArrayList<Flight> flights =
                graph.get(current);

        for (Flight flight :
                flights) {

            String next =
                    flight.getDestinationAirport()
                            .toUpperCase();

            if (!visited.contains(next)) {

                route.add(flight);

                boolean found =
                        dfs(
                                next,
                                destination,
                                visited,
                                route);

                if (found) {

                    return true;
                }

                // Backtracking
                route.remove(
                        route.size() - 1);
            }
        }

        return false;
    }

    // =========================================================
    // CHEAPEST ROUTE
    // =========================================================

    public void findCheapestRoute(
            String source,
            String destination) {

        source = source.toUpperCase();
        destination = destination.toUpperCase();

        if (!validateRoute(
                source,
                destination)) {

            return;
        }

        ArrayList<Flight> currentRoute =
                new ArrayList<>();

        ArrayList<Flight> cheapestRoute =
                new ArrayList<>();

        Set<String> visited =
                new HashSet<>();

        double[] minimumFare =
                {Double.MAX_VALUE};

        findAllRoutesByFare(
                source,
                destination,
                visited,
                currentRoute,
                cheapestRoute,
                minimumFare);

        if (cheapestRoute.isEmpty()) {

            System.out.println(
                    "\nNo route found from "
                            + source
                            + " to "
                            + destination
                            + ".");

            return;
        }

        RouteResult result =
                new RouteResult(
                        cheapestRoute);

        System.out.println(
                "\n===== CHEAPEST ROUTE =====");

        result.displayRoute();
    }

    // =========================================================
    // FIND ALL ROUTES FOR CHEAPEST
    // =========================================================

    private void findAllRoutesByFare(
            String current,
            String destination,
            Set<String> visited,
            ArrayList<Flight> currentRoute,
            ArrayList<Flight> cheapestRoute,
            double[] minimumFare) {

        visited.add(current);

        if (current.equals(destination)) {

            double fare = 0;

            for (Flight flight :
                    currentRoute) {

                fare += flight.getFare();
            }

            if (fare < minimumFare[0]) {

                minimumFare[0] = fare;

                cheapestRoute.clear();

                cheapestRoute.addAll(
                        currentRoute);
            }

            visited.remove(current);

            return;
        }

        for (Flight flight :
                graph.get(current)) {

            String next =
                    flight.getDestinationAirport()
                            .toUpperCase();

            if (!visited.contains(next)) {

                currentRoute.add(flight);

                findAllRoutesByFare(
                        next,
                        destination,
                        visited,
                        currentRoute,
                        cheapestRoute,
                        minimumFare);

                currentRoute.remove(
                        currentRoute.size() - 1);
            }
        }

        visited.remove(current);
    }

    // =========================================================
    // FASTEST ROUTE
    // =========================================================

    public void findFastestRoute(
            String source,
            String destination) {

        source = source.toUpperCase();
        destination = destination.toUpperCase();

        if (!validateRoute(
                source,
                destination)) {

            return;
        }

        ArrayList<Flight> currentRoute =
                new ArrayList<>();

        ArrayList<Flight> fastestRoute =
                new ArrayList<>();

        Set<String> visited =
                new HashSet<>();

        double[] minimumDuration =
                {Double.MAX_VALUE};

        findAllRoutesByDuration(
                source,
                destination,
                visited,
                currentRoute,
                fastestRoute,
                minimumDuration);

        if (fastestRoute.isEmpty()) {

            System.out.println(
                    "\nNo route found from "
                            + source
                            + " to "
                            + destination
                            + ".");

            return;
        }

        RouteResult result =
                new RouteResult(
                        fastestRoute);

        System.out.println(
                "\n===== FASTEST ROUTE =====");

        result.displayRoute();
    }

    // =========================================================
    // FIND ALL ROUTES FOR FASTEST
    // =========================================================

    private void findAllRoutesByDuration(
            String current,
            String destination,
            Set<String> visited,
            ArrayList<Flight> currentRoute,
            ArrayList<Flight> fastestRoute,
            double[] minimumDuration) {

        visited.add(current);

        if (current.equals(destination)) {

            double duration = 0;

            for (Flight flight :
                    currentRoute) {

                duration +=
                        flight.getDuration();
            }

            if (duration <
                    minimumDuration[0]) {

                minimumDuration[0] =
                        duration;

                fastestRoute.clear();

                fastestRoute.addAll(
                        currentRoute);
            }

            visited.remove(current);

            return;
        }

        for (Flight flight :
                graph.get(current)) {

            String next =
                    flight.getDestinationAirport()
                            .toUpperCase();

            if (!visited.contains(next)) {

                currentRoute.add(flight);

                findAllRoutesByDuration(
                        next,
                        destination,
                        visited,
                        currentRoute,
                        fastestRoute,
                        minimumDuration);

                currentRoute.remove(
                        currentRoute.size() - 1);
            }
        }

        visited.remove(current);
    }

    // =========================================================
    // VALIDATE SOURCE & DESTINATION
    // =========================================================

    private boolean validateRoute(
            String source,
            String destination) {

        if (!airports.containsKey(source)) {

            System.out.println(
                    "Source Airport not found.");

            return false;
        }

        if (!airports.containsKey(destination)) {

            System.out.println(
                    "Destination Airport not found.");

            return false;
        }

        if (source.equals(destination)) {

            System.out.println(
                    "Source and Destination are the same.");

            return false;
        }

        return true;
    }
}