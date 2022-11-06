package com.travelcompany.eshop.model;

import com.travelcompany.eshop.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderedTicket {

    /* 
    creating getter only for the id variables based on the logic that
    once set by the system an id cannot change.
     */
    @Getter
    private static int id = 0;
    private int passengerId;
    private int itineraryId;
    private PaymentMethod paymentMethod;
    private double paymentAmount;

    public OrderedTicket(int passengerId, int itineraryId, PaymentMethod paymentMethod) {
        this.passengerId = passengerId;
        this.itineraryId = itineraryId;
        this.paymentMethod = paymentMethod;
        id++;
    }

    @Override
    public String toString() {
        return "OrderedTickets{" + "id= " + id + ", passengerId=" + passengerId + ", itineraryId=" + itineraryId + ", paymentMethod=" + paymentMethod + ", paymentAmount=" + paymentAmount + '}';
    }

}
