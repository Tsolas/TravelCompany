package com.travelcompany.eshop.services;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;

public interface TicketService {

    /**
     * This method considers given customer category and payment method to
     * cumulative discount or surcharge
     *
     * @param customerCategory
     * @param paymentMethod
     * @return Returns the multiplier which can be used to calculate the final
     * price
     */
    double calculateDiscount(CustomerCategory customerCategory, PaymentMethod paymentMethod);

    /**
     * This method calculates a ticket's final price after discount or extra
     * charges
     *
     * @param price
     * @param discount
     * @return Returns final price of the ticket
     */
    double calculatePrice(double price, double discount);
}

//    /**
//     * This method saves a finalized ordered ticket after calculating discount
//     * and final price
//     *
//     * @param customer
//     * @param itinerary
//     * @param paymentMethod
//     * @param ticketRepository
//     * @see calculateDiscount
//     * @see calculatePrice
//     */
//    void orderTicket(Customer customer, Itinerary itinerary, PaymentMethod paymentMethod, OrderedTicketRepository ticketRepository);
