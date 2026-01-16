package com.gcorp.service.app.itineraryservice.app.usecases;

import com.gcorp.service.app.itineraryservice.app.commands.AddFlightToItineraryCommand;
import com.gcorp.service.app.itineraryservice.app.response.ApiResponse;
import com.gcorp.service.app.itineraryservice.app.response.CreateItineraryResponse;
import com.gcorp.service.app.itineraryservice.domain.models.ItineraryModel;
import com.gcorp.service.app.itineraryservice.domain.ports.ItineraryRepository;

public class AddNewFlightToItinerary
{
    private final ItineraryRepository itineraryRepository;

    public AddNewFlightToItinerary(ItineraryRepository itineraryRepository)
    {
        this.itineraryRepository = itineraryRepository;
    }

    public ApiResponse<CreateItineraryResponse> execute(AddFlightToItineraryCommand command)
    {
        ItineraryModel itinerary = new ItineraryModel(
                null,
                command.idFlight(),
                command.segments()
        );

        ItineraryModel createdItinerary = this.itineraryRepository.save(itinerary);

        CreateItineraryResponse itineraryResponse = new CreateItineraryResponse(
                createdItinerary.getId(),
                createdItinerary.getSegments()
        );

        return new ApiResponse<>(true, itineraryResponse, null);
    }
}
