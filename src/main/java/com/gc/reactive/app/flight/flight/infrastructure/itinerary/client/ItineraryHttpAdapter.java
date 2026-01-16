package com.gc.reactive.app.flight.flight.infrastructure.itinerary.client;

import com.gc.reactive.app.flight.flight.domain.ports.ItineraryQueryPort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ItineraryHttpAdapter implements ItineraryQueryPort
{
    private final RestTemplate restTemplate;

    public ItineraryHttpAdapter(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public ItineraryResponseDto publishFlight(AddFlightToItineraryDto commandDto)
    {
        return this.restTemplate.postForEntity(
                "http://localhost:8080/itineraries",
                new AddFlightToItineraryDto(
                        commandDto.idFlight(),
                        commandDto.segments()
                ),
                ItineraryResponseDto.class
        ).getBody();
    }
}
