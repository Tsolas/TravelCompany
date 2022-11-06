package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.model.OrderedTicket;
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
}
