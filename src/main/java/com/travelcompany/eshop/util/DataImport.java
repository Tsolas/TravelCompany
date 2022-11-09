package com.travelcompany.eshop.util;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketRepository;

public class DataImport {

    private final CustomerRepository customerRepository;
    private final ItineraryRepository itineraryRepository;
    private final OrderedTicketRepository orderedTicketRepository;
    private final static String[] CUSTOMERS = {
        "Maria Iordanou, miordanou@mail.com, Athens, Greek, INDIVIDUAL",
        "Dimitriou Dimitrios, ddimitriou@mail.com, Athens, Greek,INDIVIDUAL",
        "Ioannis Ioannou, iioannou@mail.com, Athens, Greek, BUSINESS",
        "Antonio Molianri, amolinari@mail.com, Milan, Italian, INDIVIDUAL",
        "Frederico Rossi, frossi@mail.com, Milan, Italian, INDIVIDUAL",
        "Mario Conti, mconti@mail.com, Rome, Italian, BUSINESS",
        "Nathan Martin, nmartin@mail.com, Lyon, French, BUSINESS",
        "Enzo Colli, ecollin@mail.com, Lyon, French, INDIVIDUAL",
        "Frederic Michel, fmichel@mail.com, Athens, French, INDIVIDUAL",
        "Catalina Alvares, calvares@mail.com, Madrid, Spanish, BUSINESS",
        "Axel Cortez, acortez@mail.com, Barcelona, Spanish, BUSINESS",
        "Karl Schwarz, kschwarz@mail.com, Berlin, German, BUSINESS",
        "Petra Muller, pmuller@mail.com, Munich, German, INDIVIDUAL",
        "Joao Miguel, jmiguel@mail.com, Lisbon, Portugese, BUSINESS",
        "Alda Costa, acosta@mail.com, Porto, Portugese, INDIVIDUAL"
    };
    private final static String[] ITINERARIES = {
        "ATH, PAR, 22/02/2022 13:35, SkyLines, 300",
        "ATH, LON, 22/02/2022 13:40, SkyLines, 420",
        "ATH, AMS, 22/02/2022 13:45, SkyLines, 280",
        "ATH, PAR, 22/02/2022 14:20, SkyLines, 310",
        "ATH, DUB, 22/02/2022 14:35, SkyLines, 880",
        "ATH, FRA, 22/02/2022 14:55, SkyLines, 380",
        "ATH, FRA, 22/02/2022 15:35, SkyLines, 350",
        "ATH, MEX, 22/02/2022 16:00, SkyLines, 1020",
        "ATH, DUB, 22/02/2022 16:35, SkyLines, 770",
        "BER, SKG, 11/03/2022 10:15, AirLines, 120",
        "BER, BTU, 02/02/2022 10:40, AirLines, 495",
        "LIS, STN, 19/03/2022 14:40, AirLines, 345",
        "LIS, YXU, 21/03/2022 09:20, AirLines, 815",
        "MAD, NOP, 26/03/2022 19:50, AirLines, 235",
        "BAR, PAR, 11/03/2022 11:55, AirLines, 115"
    };
    private final static String[] TICKETS = {
        "1, 2, CASH",
        "2, 3, CASH",
        "3, 3, CREDIT_CARD",
        "2, 4, CREDIT_CARD",
        "3, 4, CASH",
        "4, 7, CREDIT_CARD",
        "5, 7, CREDIT_CARD",
        "2, 10, CASH",
        "1, 3, CASH",
        "6, 5, CREDIT_CARD",
        "7, 1, CASH",
        "8, 8, CREDIT_CARD",
        "10, 6, CASH",
        "11, 13, CREDIT_CARD",
        "3, 14, CASH"
    };

    public DataImport(CustomerRepository customerRepository, ItineraryRepository itineraryRepository, OrderedTicketRepository orderedticketRepository) {
        this.customerRepository = customerRepository;
        this.itineraryRepository = itineraryRepository;
        this.orderedTicketRepository = orderedticketRepository;
    }

    /**
     * This method is created to populate the customers repository with data
     */
    public void insertCustomers() {
        for (String customers : CUSTOMERS) {
            String[] fields = customers.split(",");
            String name = fields[0].trim();
            String email = fields[1].trim();
            String address = fields[2].trim();
            String nationality = fields[3].trim();
            CustomerCategory category = CustomerCategory.valueOf(fields[4].trim());
            Customer cus = new Customer(name, email, address, nationality, category);
            customerRepository.create(cus);
        }
    }

    /**
     * This method is created to populate the Itinerary repository with data
     * without calculating the final payment amount
     */
    public void insertItineraries() {
        for (String itineraries : ITINERARIES) {
            String[] fields = itineraries.split(",");
            String departure = fields[0].trim();
            String destination = fields[1].trim();
            String date = fields[2].trim();
            String airline = fields[3].trim();
            double price = Double.parseDouble(fields[4].trim());
            Itinerary itinerary = new Itinerary(departure, destination, date, airline, price);
            itineraryRepository.create(itinerary);
        }
    }

    /**
     * This method is created to populate the OrderedTickets repository with
     * data
     */
    public void insertTickets() {
        for (String tickets : TICKETS) {
            String[] fields = tickets.split(",");
            int passengerId = Integer.parseInt(fields[0].trim());
            int itineraryId = Integer.parseInt(fields[1].trim());
            PaymentMethod payment = PaymentMethod.valueOf(fields[2].trim());
            OrderedTicket orderedticket = new OrderedTicket(passengerId, itineraryId, payment);
            orderedTicketRepository.create(orderedticket);
        }
    }

}
