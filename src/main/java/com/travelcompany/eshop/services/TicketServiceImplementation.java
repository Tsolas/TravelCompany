package com.travelcompany.eshop.services;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.DepartureAirportCodes;
import com.travelcompany.eshop.enums.DestinationAirportCodes;
import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.exceptions.BusinessExceptions;
import com.travelcompany.eshop.exceptions.BusinessExceptionsCodes;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.repository.CustomerRepository;
import com.travelcompany.eshop.repository.ItineraryRepository;
import com.travelcompany.eshop.repository.OrderedTicketRepository;

public class TicketServiceImplementation implements TicketService {

    private final CustomerRepository customerRepository;
    private final ItineraryRepository itineraryRepository;
    private final OrderedTicketRepository ticketRepository;

    public TicketServiceImplementation(CustomerRepository customerRepository, ItineraryRepository itineraryRepository, OrderedTicketRepository ticketRepository) {
        this.customerRepository = customerRepository;
        this.itineraryRepository = itineraryRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public double calculateDiscount(CustomerCategory customerCategory, PaymentMethod paymentMethod) {
        double priceMultipier;
        priceMultipier = switch (customerCategory) {
            case BUSINESS ->
                -0.1;
            default ->
                0.2;
        };
        if (paymentMethod == PaymentMethod.CREDIT_CARD) {
            return priceMultipier - 0.1;
        } else {
            return priceMultipier;
        }

    }

    @Override
    public double calculatePrice(double price, double discount) {
        return price + (price * discount);
    }

    @Override
    public void addCustomer(String name, String email, String address, String nationality, CustomerCategory customerCategory) throws BusinessExceptions {
        if (email.contains("travelcompany.com")) {
            throw new BusinessExceptions(BusinessExceptionsCodes.EMAIL_INVALID);
        }
        Customer customer = new Customer(name, email, address, nationality, customerCategory);
        customerRepository.create(customer);
    }

    @Override
    public void issueTicket(int passengerId, int itineraryId, PaymentMethod paymentMethod) throws BusinessExceptions {
        boolean cus_exists = false;
        boolean it_exists = false;
        for (Customer customer : customerRepository.readAll()) {
            if (customer.getId() == passengerId) {
                cus_exists = true;
            }
        }
        for (Itinerary itinerary : itineraryRepository.readAll()) {
            if (itinerary.getId() == itineraryId) {
                it_exists = true;
            }
        }
        if (!cus_exists) {
            throw new BusinessExceptions(BusinessExceptionsCodes.CUSTOMER_NOT_EXISTING);
        }
        if (!it_exists) {
            throw new BusinessExceptions(BusinessExceptionsCodes.ITINERARY_NOT_EXISTING);
        }
        OrderedTicket ticket = new OrderedTicket(passengerId, itineraryId, paymentMethod);
        ticketRepository.create(ticket);
    }

    @Override
    public void addItinerary(String departureAirportCode, String destinationAirportCode, String departureDate, String airlineName, double price) throws BusinessExceptions {
        DepartureAirportCodes[] departureAirportCodes = DepartureAirportCodes.values();
        DestinationAirportCodes[] destinationAirportCodes = DestinationAirportCodes.values();
        boolean dep_exists = false;
        boolean dest_exists = false;
        for (DestinationAirportCodes dest : destinationAirportCodes) {
            if (dest.toString().equals(destinationAirportCode)) {
                dest_exists = true;
            }
        }
        for (DepartureAirportCodes dep : departureAirportCodes) {
            if (dep.toString().equals(departureAirportCode)) {
                dep_exists = true;
            }
        }
        if (!dep_exists) {
            throw new BusinessExceptions(BusinessExceptionsCodes.DEPARTURE_AIRPORT_NOT_EXISTING);
        }
        if (!dest_exists) {
            throw new BusinessExceptions(BusinessExceptionsCodes.DESTINATION_AIRPORT_NOT_EXISTING);
        }
        Itinerary itinerary = new Itinerary(departureAirportCode, destinationAirportCode, departureDate, airlineName, price);
        itineraryRepository.create(itinerary);
    }

    @Override
    public void setAmount(CustomerRepository customerRepository, ItineraryRepository itineraryRepository, OrderedTicketRepository ticketRepository) {
        for (OrderedTicket ticket : ticketRepository.readAll()) {
            Customer customer = customerRepository.read(ticket.getPassengerId());
            double discount = this.calculateDiscount(customer.getCustomerCategory(), ticket.getPaymentMethod());
            Itinerary it = itineraryRepository.read(ticket.getItineraryId());
            double amount = this.calculatePrice(it.getPrice(), discount);
            ticket.setPaymentAmount(amount);
        }
    }

}
