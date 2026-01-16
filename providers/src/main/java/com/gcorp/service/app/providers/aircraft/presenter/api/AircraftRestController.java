package com.gcorp.service.app.providers.aircraft.presenter.api;

import com.gcorp.service.app.providers.aircraft.infrastructure.service.AircraftService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/aircraft")
public class AircraftRestController
{
    private final AircraftService aircraftService;

    public AircraftRestController(AircraftService aircraftService)
    {
        this.aircraftService = aircraftService;
    }

    @GetMapping(value = "/register/{model}")
    public ResponseEntity<?> getAircraftByRegistration(@PathVariable String model)
    {
        return ResponseEntity.ok(this.aircraftService.getAirCraftByRegistration(model));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<?> searchAircraftByRegistration(@RequestParam String model)
    {
        return ResponseEntity.ok(this.aircraftService.searchAirCraftsByRegistration(model));
    }

    @GetMapping(value = "/exists/{register}")
    public ResponseEntity<?> existsByRegistration(@PathVariable(value = "register") String register)
    {
        this.aircraftService.existsByRegistration(register);
        return ResponseEntity.ok().build();
    }
}
