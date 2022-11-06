package com.travelcompany.eshop.model;

import com.travelcompany.eshop.enums.PaymentMethod;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderedTicket {
//    this counter works as an id incrementor

    private static int counter = 1;
    @EqualsAndHashCode.Include
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderedTicket other = (OrderedTicket) obj;
        return this.id == other.id;
    }

}
