package com.gc.reactive.app.flight.booking.app.response;

import com.gc.reactive.app.flight.booking.domain.vos.PassengerData;
import com.gc.reactive.app.flight.flight.domain.vos.FlightSegmentData;

import java.util.Set;

public record FlightReservationResponse(
        String airline,
        PassengerData passenger,
        Set<FlightSegmentData> segments
)
{
}
