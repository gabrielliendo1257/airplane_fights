package com.gc.reactive.app.flight.flight.domain.ports;

import com.gc.reactive.app.flight.flight.infrastructure.itinerary.client.AddFlightToItineraryDto;
import com.gc.reactive.app.flight.flight.infrastructure.itinerary.client.ItineraryResponseDto;

public interface ItineraryQueryPort
{
    ItineraryResponseDto publishFlight(AddFlightToItineraryDto commandDto);
}
