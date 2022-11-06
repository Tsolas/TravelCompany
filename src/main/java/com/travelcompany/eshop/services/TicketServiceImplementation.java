package com.travelcompany.eshop.services;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.repository.OrderedTicketRepository;

public class TicketServiceImplementation implements TicketService {

    /**
     * This method considers given customer category and payment method to
     * cumulative discount or surcharge
     *
     * @param customerCategory
     * @param paymentMethod
     * @return Returns the multiplier which can be used to calculate the final
     * price
     */
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

    /**
     * This method saves a finalized ordered ticket after calculating discount
     * and final price
     *
     * @param customer
     * @param itinerary
     * @param paymentMethod
     * @param ticketRepository
     * @see calculateDiscount
     * @see calculatePrice
     */
    @Override
    public void orderTicket(Customer customer, Itinerary itinerary, PaymentMethod paymentMethod, OrderedTicketRepository ticketRepository) {
        int customerId = customer.getId();
        int itineraryId = itinerary.getId();
        OrderedTicket ticket = new OrderedTicket(customerId, itineraryId, paymentMethod);
        CustomerCategory category = customer.getCustomerCategory();
        double discount = this.calculateDiscount(category, paymentMethod);
        double price = itinerary.getPrice();
        double paymentAmount = this.calculatePrice(price, discount);
        ticket.setPaymentAmount(paymentAmount);
        ticketRepository.insertOrderedTicket(ticket);

    }

    /**
     * This method calculates a ticket's final price after discount or extra
     * charges
     *
     * @param price
     * @param discount
     * @return Returns final price of the ticket
     */
    @Override
    public double calculatePrice(double price, double discount) {
        return price + (price * discount);
    }

}
