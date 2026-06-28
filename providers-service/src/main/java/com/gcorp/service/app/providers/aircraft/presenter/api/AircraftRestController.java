package com.gcorp.service.app.providers.aircraft.presenter.api;

import com.gcorp.service.app.providers.aircraft.infrastructure.service.AircraftService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class AircraftRestController
{
    private final AircraftService aircraftService;

    public AircraftRestController(AircraftService aircraftService)
    {
        this.aircraftService = aircraftService;
    }

    @GetMapping(value = "/aircrafts")
    public ResponseEntity<?> searchAircraftByRegistrationAndModel(
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String register,

            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    )
    {
        return ResponseEntity.ok(this.aircraftService.search(model, register, page, size));
    }

    @GetMapping(value = "/aircrafts/{register}")
    public ResponseEntity<?> bringAircraftByRegistration(@PathVariable String register)
    {
        return ResponseEntity.ok(this.aircraftService.getAirCraftByRegistration(register));
    }
}
