package com.gcorp.service.app.itineraryservice.domain.ports;

import com.gcorp.service.app.itineraryservice.domain.models.ItineraryModel;

public interface ItineraryRepository
{
    ItineraryModel save(ItineraryModel itinerary);
}
