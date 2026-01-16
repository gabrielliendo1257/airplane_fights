package com.gc.reactive.app.flight.flight.presenter.api;

import com.gc.reactive.app.flight.flight.app.commands.CreateFlightCommand;
import com.gc.reactive.app.flight.flight.app.response.ApiResponse;
import com.gc.reactive.app.flight.flight.app.usecases.CreateFlightUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class FlightRestController
{
    private final CreateFlightUseCase createFlightUseCase;

    public FlightRestController(CreateFlightUseCase createFlightUseCase)
    {
        this.createFlightUseCase = createFlightUseCase;
    }

    @PostMapping(value = "/flight")
    public ResponseEntity<?> saveFlight(CreateFlightCommand command)
    {
        ApiResponse<?> apiResponse = this.createFlightUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
}
