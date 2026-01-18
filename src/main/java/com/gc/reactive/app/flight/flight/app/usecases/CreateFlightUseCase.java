package com.gc.reactive.app.flight.flight.app.usecases;

import com.gc.reactive.app.flight.flight.app.commands.CreateFlightCommand;
import com.gc.reactive.app.flight.flight.app.response.ApiResponse;
import com.gc.reactive.app.flight.flight.app.response.CreateFlightResponse;
import com.gc.reactive.app.flight.flight.app.response.ItineraryPublicationResult;
import com.gc.reactive.app.flight.flight.domain.models.Flight;
import com.gc.reactive.app.flight.flight.domain.ports.FlightRepository;
import com.gc.reactive.app.flight.flight.domain.ports.ItineraryQueryPort;
import com.gc.reactive.app.flight.flight.domain.vos.FlightNumber;
import com.gc.reactive.app.flight.flight.utils.enums.FlightStatus;
import com.gc.reactive.app.flight.flight.app.commands.PublishFlightToItineraryCommand;

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

        PublishFlightToItineraryCommand commandDto = new PublishFlightToItineraryCommand(
                createdFlight.getId(),
                createdFlight.getSegments()
        );

        ItineraryPublicationResult itineraryPublicationResult = this.itineraryQueryPort.publishFlight(commandDto);

        return new ApiResponse<>(
                true,
                new CreateFlightResponse(
                        itineraryPublicationResult.itineraryId(),
                        createdFlight.getNumber().flightNumber(),
                        itineraryPublicationResult.segments()
                ),
                null
        );
    }
}
