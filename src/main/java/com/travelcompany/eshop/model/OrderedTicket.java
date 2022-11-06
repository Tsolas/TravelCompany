package com.travelcompany.eshop.model;

import com.travelcompany.eshop.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderedTicket {
//    this counter works as an id incrementor
    private static int counter = 1;
    private int id;
    private int passengerId;
    private int itineraryId;
    private PaymentMethod paymentMethod;
    private double paymentAmount;

    public OrderedTicket(int passengerId, int itineraryId, PaymentMethod paymentMethod) {
        this.passengerId = passengerId;
        this.itineraryId = itineraryId;
        this.paymentMethod = paymentMethod;
        this.id = counter;
        counter++;
    }

    @Override
    public String toString() {
        return "OrderedTickets{" + "id= " + id + ", passengerId=" + passengerId + ", itineraryId=" + itineraryId + ", paymentMethod=" + paymentMethod + ", paymentAmount=" + paymentAmount + '}';
    }

}
