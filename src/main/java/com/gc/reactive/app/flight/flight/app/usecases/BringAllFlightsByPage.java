package com.gc.reactive.app.flight.flight.app.usecases;

import com.gc.reactive.app.flight.flight.app.response.ApiResponse;
import com.gc.reactive.app.flight.flight.app.response.PageResult;
import com.gc.reactive.app.flight.flight.domain.models.AppPageRequest;
import com.gc.reactive.app.flight.flight.domain.models.Flight;
import com.gc.reactive.app.flight.flight.domain.ports.FlightRepository;

public class BringAllFlightsByPage
{
    private final FlightRepository flightRepository;

    public BringAllFlightsByPage(FlightRepository flightRepository)
    {
        this.flightRepository = flightRepository;
    }

    public ApiResponse<?> execute(AppPageRequest appPageRequest) {
        PageResult<Flight> flightPage = this.flightRepository.findAllByPage(appPageRequest);

        return new ApiResponse<>(true, flightPage, null);
    }
}
