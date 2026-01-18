package com.gc.reactive.app.flight.flight.infrastructure.itinerary.client;

import com.gc.reactive.app.flight.flight.app.commands.PublishFlightToItineraryCommand;
import com.gc.reactive.app.flight.flight.app.response.ItineraryPublicationResult;
import com.gc.reactive.app.flight.flight.domain.ports.ItineraryQueryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ItineraryHttpAdapter implements ItineraryQueryPort
{
    private final RestTemplate restTemplate;

    public ItineraryHttpAdapter(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public ItineraryPublicationResult publishFlight(PublishFlightToItineraryCommand commandDto)
    {
        ItineraryResponseDto itineraryResponseDto = this.restTemplate.postForEntity(
                "http://localhost:8080/itineraries",
                new PublishFlightToItineraryCommand(
                        commandDto.idFlight(),
                        commandDto.segments()
                ),
                ItineraryResponseDto.class
        ).getBody();
        log.info("Published Flight: {}", itineraryResponseDto);

        assert itineraryResponseDto != null;
        return new ItineraryPublicationResult(
                itineraryResponseDto.itineraryId(),
                itineraryResponseDto.segments()
        );
    }
}
