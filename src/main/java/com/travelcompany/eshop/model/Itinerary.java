package com.travelcompany.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Itinerary {
//    this counter works as an id incrementor
    private static int counter = 1;
    private int id;
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
        this.id = counter;
        id++;
    }

    @Override
    public String toString() {
        return "Itinerary{" + "id= " + id + ", departureAirportCode= " + departureAirportCode + ", destinationAirportCode= " + destinationAirportCode + ", departureDate= " + departureDate + ", airlineName= " + airlineName + ", price= " + price + '}';
    }

}
