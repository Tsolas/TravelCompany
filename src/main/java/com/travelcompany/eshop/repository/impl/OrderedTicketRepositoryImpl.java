/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.model.OrderedTicket;
import com.travelcompany.eshop.repository.OrderedTicketRepository;

/**
 *
 * @author Giorgos
 */
public class OrderedTicketRepositoryImpl extends RepositoryImpl<OrderedTicket> implements OrderedTicketRepository {

    @Override
    public void updateAll(int ticketId, OrderedTicket data) {
        OrderedTicket ticket = read(ticketId);
        if (ticket != null) {
            ticket.setPassengerId(data.getPassengerId());
            ticket.setItineraryId(data.getItineraryId());
            ticket.setPaymentMethod(PaymentMethod.CREDIT_CARD);
            //to calculate amount
        }
    }

}
