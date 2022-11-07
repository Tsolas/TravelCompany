package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.OrderedTicket;

public interface OrderedTicketRepository extends Repository<OrderedTicket> {

    void updateAll(int ticketId, OrderedTicket data);
}
