package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Itinerary;
import java.util.ArrayList;
import java.util.List;

public class ItineraryRepository {

    List<Itinerary> itineraries = new ArrayList<>();

    //CRUD Implementation
    //create
    public void insertItinerary(Itinerary itinerary) {
        itineraries.add(itinerary);
    }

    //read
    public void printItineraries() {
        for (Itinerary itinerary : itineraries) {
            System.out.println(itinerary);
        }
    }

    /**
     * This method deletes an Itinerary selected by its id.
     *
     * @param id
     */
    public void deleteItinerary(int id) {
        itineraries.removeIf(obj -> (obj.getId() == id));
    }

    /**
     * This method updates an itinerary's info The name updateEntry is given as
     * the method currently only updates a whole entry and not one or more
     * fields of an entry
     *
     * @param id
     * @param departureAirportCode
     * @param destinationAirportCode
     * @param departureDate
     * @param airlineName
     * @param price
     */
    public void updateEntry(int id, String departureAirportCode, String destinationAirportCode, String departureDate, String airlineName, double price) {
        for (Itinerary its : itineraries) {
            if (its.getId() == id) {
                its.setDepartureAirportCode(departureAirportCode);
                its.setDestinationAirportCode(destinationAirportCode);
                its.setDepartureDate(departureDate);
                its.setAirlineName(airlineName);
                its.setPrice(price);
            }
        }
    }

}
