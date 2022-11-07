package com.travelcompany.eshop.repository.impl;

import com.travelcompany.eshop.model.Itinerary;
import com.travelcompany.eshop.repository.ItineraryRepository;

public class ItineraryRepositoryImpl extends RepositoryImpl<Itinerary> implements ItineraryRepository {

    @Override
    public void updateAll(int itineraryId, Itinerary data) {
        Itinerary itinerary = read(itineraryId);

        if (itinerary != null) {
            itinerary.setDepartureAirportCode(data.getDepartureAirportCode());
            itinerary.setDestinationAirportCode(data.getDestinationAirportCode());
            itinerary.setDepartureDate(data.getDepartureDate());
            itinerary.setAirlineName(data.getAirlineName());
            itinerary.setPrice(data.getPrice());
        }
    }

}
