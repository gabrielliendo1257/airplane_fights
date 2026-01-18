package com.gc.reactive.app.flight.flight.presenter.api;

import com.gc.reactive.app.flight.flight.app.commands.CreateFlightCommand;
import com.gc.reactive.app.flight.flight.app.request.CreateFlightRequest;
import com.gc.reactive.app.flight.flight.app.response.ApiResponse;
import com.gc.reactive.app.flight.flight.app.usecases.BringAllFlightsByPage;
import com.gc.reactive.app.flight.flight.app.usecases.CreateFlightUseCase;
import com.gc.reactive.app.flight.flight.domain.models.AppPageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class FlightRestController
{
    private final CreateFlightUseCase createFlightUseCase;
    private final BringAllFlightsByPage bringAllFlightsByPage;

    public FlightRestController(
            CreateFlightUseCase createFlightUseCase,
            BringAllFlightsByPage bringAllFlightsByPage
    )
    {
        this.createFlightUseCase = createFlightUseCase;
        this.bringAllFlightsByPage = bringAllFlightsByPage;
    }

    @GetMapping(value = "/flights/test")
    public String test()
    {
        return "Hello Customer";
    }

    @PostMapping(value = "/flights")
    public ResponseEntity<?> flightSavingProcess(CreateFlightRequest flightRequest)
    {
        ApiResponse<?> apiResponse = this.createFlightUseCase.execute(
                CreateFlightCommand.from(flightRequest)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping(value = "/flights/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable String id)
    {
        return null;
    }

    @GetMapping(value = "/flights")
    public ResponseEntity<?> bringAllFlightsBYPages(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    )
    {
        ApiResponse<?> apiResponse = this.bringAllFlightsByPage.execute(
                new AppPageRequest(page, size)
        );
        return ResponseEntity.ok(apiResponse);
    }
}
