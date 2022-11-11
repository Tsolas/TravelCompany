package com.travelcompany.eshop;

import com.travelcompany.eshop.dto.Reports;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketRepository;
import com.travelcompany.eshop.repository.impl.CustomerRepositoryImpl;
import com.travelcompany.eshop.repository.impl.ItineraryRepositoryImpl;
import com.travelcompany.eshop.repository.impl.OrderedTicketRepositoryImpl;
import com.travelcompany.eshop.services.TicketService;
import com.travelcompany.eshop.services.TicketServiceImplementation;
import com.travelcompany.eshop.util.DataImport;
import com.travelcompany.eshop.util.JsonPrint;

public class TravelCompany {

    public static void main(String[] args) {
        //instansiate the repositories
        OrderedTicketRepository ticketRepository = new OrderedTicketRepositoryImpl();
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();

        //instansiate the services
        TicketService ticketService = new TicketServiceImplementation(customerRepository, itineraryRepository, ticketRepository);

        //instantiate the utilities
        DataImport dataImport = new DataImport(customerRepository, itineraryRepository, ticketRepository);
        JsonPrint output = new JsonPrint(customerRepository, itineraryRepository, ticketRepository);

        //populate the repositories
        dataImport.insertTickets();
        dataImport.insertCustomers();
        dataImport.insertItineraries();

        //calculate and insert the Payment amount for each ticket
        ticketService.setAmount(customerRepository, itineraryRepository, ticketRepository);

        //instatiate the reports
        Reports report = new Reports();

        //print the results
        output.printNumberCost(report);
        output.printItinerariesPerDestination(report);
        output.printItinerariesPerDeparture(report);
        output.printMostTickets(report);
        output.printLargestCost(report);
        output.printNoTickets(report);
    }
}
