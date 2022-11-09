package com.travelcompany.eshop;

import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketRepository;
import com.travelcompany.eshop.repository.impl.CustomerRepositoryImpl;
import com.travelcompany.eshop.repository.impl.ItineraryRepositoryImpl;
import com.travelcompany.eshop.repository.impl.OrderedTicketRepositoryImpl;
import com.travelcompany.eshop.services.TicketService;
import com.travelcompany.eshop.services.TicketServiceImplementation;
import com.travelcompany.eshop.util.DataImport;

public class TravelCompany {

    public static void main(String[] args) {

        OrderedTicketRepository ticketRepository = new OrderedTicketRepositoryImpl();

        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl();

        TicketService ticketService = new TicketServiceImplementation(customerRepository, itineraryRepository, ticketRepository);
        DataImport dataImport = new DataImport(customerRepository, itineraryRepository, ticketRepository);
        dataImport.insertTickets();
        dataImport.insertCustomers();
        dataImport.insertItineraries();

        for (OrderedTicket ticket : ticketRepository.readAll()) {
            Customer customer = customerRepository.read(ticket.getPassengerId());
            double discount = ticketService.calculateDiscount(customer.getCustomerCategory(), ticket.getPaymentMethod());
            Itinerary it = itineraryRepository.read(ticket.getItineraryId());
            double amount = ticketService.calculatePrice(it.getPrice(), discount);
            ticket.setPaymentAmount(amount);
        }
        System.out.println(ticketRepository.readAll());
    }
}
