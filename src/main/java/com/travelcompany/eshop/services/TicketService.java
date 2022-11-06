package com.travelcompany.eshop.services;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.repository.OrderedTicketRepository;

public interface TicketService {

    double calculateDiscount(CustomerCategory customerCategory, PaymentMethod paymentMethod);

    double calculatePrice(double price, double discount);

    void orderTicket(Customer customer, Itinerary itinerary, PaymentMethod paymentMethod, OrderedTicketRepository ticketRepository);

}
