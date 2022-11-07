package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.model.Customer;
import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.services.TicketService;
import java.util.ArrayList;
import java.util.List;

public class OrderedTicketRepository {

    List<OrderedTicket> orderedTickets = new ArrayList<>();

    //CRUD implementation
    //create
    public void insertOrderedTicket(OrderedTicket ticket) {
        orderedTickets.add(ticket);
    }

    //read
    public void printOrderedTickets() {
        for (OrderedTicket ticket : orderedTickets) {
            System.out.println(ticket);
        }
    }

    /**
     * This method deletes an OrderedTicket selected by its id.
     *
     * @param id
     */
    public void deleteOrderedTicket(int id) {
        orderedTickets.removeIf(obj -> (obj.getId() == id));
    }

    /**
     * This method updates an OrderedTicket's info The name updateEntry is given
     * as the method currently only updates a whole entry and not one or more
     * fields of an entry
     *
     * @param ticketId
     * @param passengerId
     * @param itineraryId
     * @param paymentMethod
     */
    public void updateEntry(int ticketId, int passengerId, int itineraryId, PaymentMethod paymentMethod) {
        for (OrderedTicket ticket : orderedTickets) {
            if (ticket.getId() == ticketId) {
                ticket.setPassengerId(passengerId);
                ticket.setItineraryId(itineraryId);
                ticket.setPaymentMethod(paymentMethod);
                //Payment ammount to be calculated
            }
        }
    }

    /**
     * This method contains hard-coded mock data to be added in orderedTickets
     * list could be updated to get data from external sources in addition it
     * calculates the PaymentAmount and inserts it for each ticket
     *
     *
     * @param ticketService
     * @param customerRepository
     * @param itineraryRepository
     */
    public void populateOrderedTickets(TicketService ticketService, CustomerRepository customerRepository, ItineraryRepository itineraryRepository) {
        orderedTickets.add(new OrderedTicket(1, 2, PaymentMethod.CASH));
        orderedTickets.add(new OrderedTicket(2, 3, PaymentMethod.CASH));
        orderedTickets.add(new OrderedTicket(3, 3, PaymentMethod.CREDIT_CARD));
        orderedTickets.add(new OrderedTicket(2, 4, PaymentMethod.CREDIT_CARD));
        orderedTickets.add(new OrderedTicket(3, 4, PaymentMethod.CASH));
        orderedTickets.add(new OrderedTicket(4, 7, PaymentMethod.CREDIT_CARD));
        orderedTickets.add(new OrderedTicket(5, 7, PaymentMethod.CREDIT_CARD));
        orderedTickets.add(new OrderedTicket(2, 10, PaymentMethod.CASH));
        orderedTickets.add(new OrderedTicket(1, 3, PaymentMethod.CASH));
        orderedTickets.add(new OrderedTicket(6, 5, PaymentMethod.CREDIT_CARD));
        orderedTickets.add(new OrderedTicket(7, 1, PaymentMethod.CASH));
        orderedTickets.add(new OrderedTicket(8, 8, PaymentMethod.CREDIT_CARD));
        orderedTickets.add(new OrderedTicket(10, 6, PaymentMethod.CASH));
        orderedTickets.add(new OrderedTicket(11, 13, PaymentMethod.CREDIT_CARD));
        orderedTickets.add(new OrderedTicket(14, 14, PaymentMethod.CASH));
        for (OrderedTicket orderedTicket : orderedTickets) {
            for (Customer customer : customerRepository.customers) {
                if (orderedTicket.getPassengerId() == customer.getId()) {
                    double discount = ticketService.calculateDiscount(customer.getCustomerCategory(), orderedTicket.getPaymentMethod());
                    for (Itinerary itinerary : itineraryRepository.itineraries) {
                        if (orderedTicket.getItineraryId() == itinerary.getId()) {
                            double paymentAmount = ticketService.calculatePrice(itinerary.getPrice(), discount);
                            orderedTicket.setPaymentAmount(paymentAmount);
                        }
                    }
                }
            }
        }
    }
}
