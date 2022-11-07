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

    /**
     * This method contains hard-coded mock data to be added in itineraries list
     * could be updated to get data from external sources
     */
    public void populateItineraries() {
        itineraries.add(new Itinerary("ATH", "PAR", "22/02/2022 13:35", "SkyLines", 300));
        itineraries.add(new Itinerary("ATH", "LON", "22/02/2022 13:40", "SkyLines", 420));
        itineraries.add(new Itinerary("ATH", "AMS", "22/02/2022 13:45", "SkyLines", 280));
        itineraries.add(new Itinerary("ATH", "PAR", "22/02/2022 14:20", "SkyLines", 310));
        itineraries.add(new Itinerary("ATH", "DUB", "22/02/2022 14:35", "SkyLines", 880));
        itineraries.add(new Itinerary("ATH", "FRA", "22/02/2022 14:55", "SkyLines", 380));
        itineraries.add(new Itinerary("ATH", "FRA", "22/02/2022 15:35", "SkyLines", 350));
        itineraries.add(new Itinerary("ATH", "MEX", "22/02/2022 16:00", "SkyLines", 1020));
        itineraries.add(new Itinerary("ATH", "DUB", "22/02/2022 16:35", "SkyLines", 770));
        itineraries.add(new Itinerary("BER", "SKG", "11/03/2022 10:15", "AirLines", 120));
        itineraries.add(new Itinerary("BER", "BTU", "02/02/2022 10:40", "AirLines", 495));
        itineraries.add(new Itinerary("LIS", "STN", "19/03/2022 14:40", "AirLines", 345));
        itineraries.add(new Itinerary("LIS", "YXU", "21/03/2022 09:20", "AirLines", 815));
        itineraries.add(new Itinerary("MAD", "NOP", "26/03/2022 19:50", "AirLines", 235));
        itineraries.add(new Itinerary("BAR", "PAR", "11/03/2022 11:55", "AirLines", 115));
    }

}
