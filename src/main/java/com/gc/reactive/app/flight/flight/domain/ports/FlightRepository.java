package com.gc.reactive.app.flight.flight.domain.ports;

import com.gc.reactive.app.flight.flight.domain.models.Flight;

public interface FlightRepository
{
    Flight findById(Integer id);

    Flight save(Flight flight);
}
