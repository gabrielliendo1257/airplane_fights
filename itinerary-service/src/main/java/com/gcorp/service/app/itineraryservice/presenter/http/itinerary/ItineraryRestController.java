package com.gcorp.service.app.itineraryservice.presenter.http.itinerary;

import com.gcorp.service.app.itineraryservice.app.commands.AddFlightToItineraryCommand;
import com.gcorp.service.app.itineraryservice.app.response.ApiResponse;
import com.gcorp.service.app.itineraryservice.app.usecases.AddNewFlightToItinerary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ItineraryRestController
{
    private final AddNewFlightToItinerary addNewFlightToItinerary;

    public ItineraryRestController(AddNewFlightToItinerary addNewFlightToItinerary)
    {
        this.addNewFlightToItinerary = addNewFlightToItinerary;
    }

    @PostMapping(value = "/itineraries")
    public ResponseEntity<?> addFlightToItinerary(AddFlightToItineraryCommand command) {
        ApiResponse<?> apiResponse = this.addNewFlightToItinerary.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
