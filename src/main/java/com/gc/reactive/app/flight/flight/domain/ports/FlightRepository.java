package com.gc.reactive.app.flight.flight.domain.ports;

import com.gc.reactive.app.flight.flight.app.response.PageResult;
import com.gc.reactive.app.flight.flight.domain.models.AppPageRequest;
import com.gc.reactive.app.flight.flight.domain.models.Flight;

public interface FlightRepository
{
    Flight findById(Integer id);

    Flight save(Flight flight);

    PageResult<Flight> findAllByPage(AppPageRequest pageRequest);
}
