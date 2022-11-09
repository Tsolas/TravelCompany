package com.travelcompany.eshop.services;

import com.travelcompany.eshop.enums.CustomerCategory;
import com.travelcompany.eshop.enums.PaymentMethod;
import com.travelcompany.eshop.exceptions.BusinessExceptions;

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

    /**
     * Creates a new customer and inserts it in the repository
     *
     * @param name
     * @param email
     * @param address
     * @param nationality
     * @param customerCategory
     * @throws com.travelcompany.eshop.exceptions.BusinessExceptions
     */
    void addCustomer(String name, String email, String address, String nationality, CustomerCategory customerCategory) throws BusinessExceptions;

    /**
     * Issues a ticket and inserts it in the repository
     *
     * @param passengerId
     * @param itineraryId
     * @param paymentMethod
     * @throws BusinessExceptions
     */
    void issueTicket(int passengerId, int itineraryId, PaymentMethod paymentMethod) throws BusinessExceptions;

    /**
     * Creates a new itinerary and inserts it in the repository
     *
     * @param departureAirportCode
     * @param destinationAirportCode
     * @param departureDate
     * @param airlineName
     * @param price
     * @throws BusinessExceptions
     */
    void addItinerary(String departureAirportCode, String destinationAirportCode, String departureDate, String airlineName, double price) throws BusinessExceptions;
}
