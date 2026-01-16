package com.gc.reactive.app.flight.flight.infrastructure.module;

import com.gc.reactive.app.flight.flight.app.usecases.CreateFlightUseCase;
import com.gc.reactive.app.flight.flight.domain.ports.FlightRepository;
import com.gc.reactive.app.flight.flight.domain.ports.ItineraryQueryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfiguration
{
    @Bean
    CreateFlightUseCase createFlightUseCase(
            FlightRepository flightRepository,
            ItineraryQueryPort itineraryQueryPort
    )
    {
        return new CreateFlightUseCase(flightRepository, itineraryQueryPort);
    }
}
