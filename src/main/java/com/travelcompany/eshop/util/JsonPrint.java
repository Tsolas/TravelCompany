package com.travelcompany.eshop.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.travelcompany.eshop.dto.Reports;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonPrint {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    CustomerRepository customerRepository;
    ItineraryRepository itineraryRepository;
    OrderedTicketRepository ticketRepository;

    /**
     * Prints the total number and the cost of tickets for all customers in Json
     * format
     *
     * @param report
     */
    public void printNumberCost(Reports report) {
        report.calculateCostOfTickets(ticketRepository);
        report.calculateNumberOfTickets(ticketRepository);
        System.out.println(gson.toJson(report));
    }

    /**
     * Prints the total offered itineraries per destination airport in Json
     * format
     *
     * @param report
     */
    public void printItinerariesPerDestination(Reports report) {
        System.out.println("Offered Itineraries per destination airport:");
        System.out.println(gson.toJson(report.getItinerariesPerDestination(itineraryRepository)));
    }

    /**
     * Prints the total offered itineraries per departure airport in Json format
     *
     * @param report
     */
    public void printItinerariesPerDeparture(Reports report) {
        System.out.println("Offered Itineraries per departure airport:");
        System.out.println(gson.toJson(report.getItinerariesPerDeparture(itineraryRepository)));
    }

    /**
     * Prints the customers with the most tickets in Json format
     *
     * @param report
     */
    public void printMostTickets(Reports report) {
        System.out.println("Customers with the most tickets:");
        System.out.println(gson.toJson(report.getMostTickets(ticketRepository, customerRepository)));
    }

    /**
     * Prints the customers with the largest purchase in Json format
     *
     * @param report
     */
    public void printLargestCost(Reports report) {
        System.out.println("Customers with the largest purchase:");
        System.out.println(gson.toJson(report.getlargestCost(ticketRepository, customerRepository)));
    }

    /**
     * Prints the customers that purchased no tickets in Json format
     *
     * @param report
     */
    public void printNoTickets(Reports report) {
        System.out.println("Customers that purchased no tickets:");
        System.out.println(gson.toJson(report.getNoTickets(ticketRepository, customerRepository)));

    }

}
