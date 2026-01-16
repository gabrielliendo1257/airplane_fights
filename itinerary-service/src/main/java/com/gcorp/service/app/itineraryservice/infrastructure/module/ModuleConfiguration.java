package com.gcorp.service.app.itineraryservice.infrastructure.module;

import com.gcorp.service.app.itineraryservice.app.usecases.AddNewFlightToItinerary;
import com.gcorp.service.app.itineraryservice.domain.ports.ItineraryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfiguration
{
    private final ItineraryRepository itineraryRepository;

    public ModuleConfiguration(ItineraryRepository itineraryRepository)
    {
        this.itineraryRepository = itineraryRepository;
    }

    @Bean
    AddNewFlightToItinerary addNewFlightToItinerary() {
        return new AddNewFlightToItinerary(itineraryRepository);
    }
}
