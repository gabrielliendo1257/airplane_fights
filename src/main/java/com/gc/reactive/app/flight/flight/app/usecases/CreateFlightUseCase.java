package com.gc.reactive.app.flight.flight.app.usecases;

import com.gc.reactive.app.flight.flight.app.commands.CreateFlightCommand;
import com.gc.reactive.app.flight.flight.app.response.ApiResponse;
import com.gc.reactive.app.flight.flight.app.response.CreateFlightResponse;
import com.gc.reactive.app.flight.flight.domain.models.Flight;
import com.gc.reactive.app.flight.flight.domain.ports.FlightRepository;
import com.gc.reactive.app.flight.flight.domain.ports.ItineraryQueryPort;
import com.gc.reactive.app.flight.flight.domain.vos.FlightNumber;
import com.gc.reactive.app.flight.flight.infrastructure.entities.FlightStatus;
import com.gc.reactive.app.flight.flight.infrastructure.itinerary.client.AddFlightToItineraryDto;
import com.gc.reactive.app.flight.flight.infrastructure.itinerary.client.ItineraryResponseDto;

public class CreateFlightUseCase
{
    private final FlightRepository flightRepository;
    private final ItineraryQueryPort itineraryQueryPort;

    public CreateFlightUseCase(FlightRepository flightRepository, ItineraryQueryPort itineraryQueryPort)
    {
        this.flightRepository = flightRepository;
        this.itineraryQueryPort = itineraryQueryPort;
    }

    public ApiResponse<CreateFlightResponse> execute(CreateFlightCommand command)
    {
        Flight flight = new Flight(
                null,
                new FlightNumber("AAAAA"),
                FlightStatus.SCHEDULED,
                command.flightSegments()
        );

        Flight createdFlight = this.flightRepository.save(flight);

        AddFlightToItineraryDto commandDto = new AddFlightToItineraryDto(
                createdFlight.getId(),
                createdFlight.getSegments()
        );

        ItineraryResponseDto itineraryResponse = this.itineraryQueryPort.publishFlight(commandDto);

        return new ApiResponse<>(
                true,
                new CreateFlightResponse(
                        itineraryResponse.itineraryId(),
                        createdFlight.getNumber().flightNumber(),
                        itineraryResponse.segments()
                ),
                null
        );
    }
}
