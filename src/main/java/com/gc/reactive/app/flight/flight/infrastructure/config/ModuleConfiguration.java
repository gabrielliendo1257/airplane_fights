package com.gc.reactive.app.flight.flight.infrastructure.config;

import com.gc.reactive.app.flight.flight.app.usecases.BringAllFlightsByPage;
import com.gc.reactive.app.flight.flight.app.usecases.CreateFlightUseCase;
import com.gc.reactive.app.flight.flight.domain.ports.FlightRepository;
import com.gc.reactive.app.flight.flight.domain.ports.ItineraryQueryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfiguration
{
    private final FlightRepository flightRepository;

    public ModuleConfiguration(FlightRepository flightRepository)
    {
        this.flightRepository = flightRepository;
    }

    @Bean
    CreateFlightUseCase createFlightUseCase(
            ItineraryQueryPort itineraryQueryPort
    )
    {
        return new CreateFlightUseCase(this.flightRepository, itineraryQueryPort);
    }

    @Bean
    BringAllFlightsByPage bringAllFlightsByPage()
    {
        return new BringAllFlightsByPage(this.flightRepository);
    }
}
