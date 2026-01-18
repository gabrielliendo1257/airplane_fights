package com.gc.reactive.app.flight.flight.domain.ports;

import com.gc.reactive.app.flight.flight.app.commands.PublishFlightToItineraryCommand;
import com.gc.reactive.app.flight.flight.app.response.ItineraryPublicationResult;

public interface ItineraryQueryPort
{
    ItineraryPublicationResult publishFlight(PublishFlightToItineraryCommand commandDto);
}
