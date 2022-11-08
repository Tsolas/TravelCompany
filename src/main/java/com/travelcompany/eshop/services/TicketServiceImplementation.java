package com.travelcompany.eshop.services;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;

public class TicketServiceImplementation implements TicketService {

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

    @Override
    public double calculatePrice(double price, double discount) {
        return price + (price * discount);
    }
}
