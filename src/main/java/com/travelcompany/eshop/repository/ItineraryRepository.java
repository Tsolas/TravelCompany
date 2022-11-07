package com.travelcompany.eshop.repository;

import com.travelcompany.eshop.model.Itinerary;

public interface ItineraryRepository extends Repository<Itinerary> {

    void updateAll(int itineraryId, Itinerary data);
}
