package service;

import graph.FlightGraph;
import model.Airport;
import model.Flight;

public class RouteService {

    private FlightGraph graph;

    public RouteService() {

        graph = new FlightGraph();
    }

    public void addAirport(Airport airport) {

        graph.addAirport(airport);
    }

    public void displayAirports() {

        graph.displayAirports();
    }

    public void searchAirport(String code) {

        graph.searchAirport(code);
    }

    public void addFlight(Flight flight) {

        graph.addFlight(flight);
    }

    public void displayFlights() {

        graph.displayFlights();
    }

    public void deleteAirport(String code) {

        graph.deleteAirport(code);
    }

    public void deleteFlight(
            String flightNumber) {

        graph.deleteFlight(
                flightNumber);
    }

    public void displayGraph() {

        graph.displayGraph();
    }

    public void findRouteBFS(
            String source,
            String destination) {

        graph.findRouteBFS(
                source,
                destination);
    }

    public void findRouteDFS(
            String source,
            String destination) {

        graph.findRouteDFS(
                source,
                destination);
    }

    public void findCheapestRoute(
            String source,
            String destination) {

        graph.findCheapestRoute(
                source,
                destination);
    }

    public void findFastestRoute(
            String source,
            String destination) {

        graph.findFastestRoute(
                source,
                destination);
    }
}