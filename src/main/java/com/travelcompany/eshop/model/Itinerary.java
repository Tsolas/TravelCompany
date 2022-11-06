package com.travelcompany.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Itinerary {

    /* 
    creating getter only for the id variables based on the logic that
    once set by the system an id cannot change.
     */
    @Getter
    private static int id;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String airlineName;
    private double price;

    public Itinerary(String departureAirportCode, String destinationAirportCode, String departureDate, String airlineName, double price) {
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.airlineName = airlineName;
        this.price = price;
        id++;
    }

    /*
    overide the toString method so as to print static field id
    **/
    @Override
    public String toString() {
        return "Itinerary{" + "id= " + id + ", departureAirportCode= " + departureAirportCode + ", destinationAirportCode= " + destinationAirportCode + ", departureDate= " + departureDate + ", airlineName= " + airlineName + ", price= " + price + '}';
    }

}
