package com.gcorp.service.app.providers.airport.presenter.api;

import com.gcorp.service.app.providers.airport.infrastructure.services.AirportService;
import com.gcorp.service.app.providers.airport.presenter.dto.AirportDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class AirportRestController
{
    private final AirportService airportService;

    public AirportRestController(AirportService airportService)
    {
        this.airportService = airportService;
    }

    @PostMapping(value = "/airports")
    public ResponseEntity<?> saveAirport(@RequestBody AirportDto airport)
    {
        this.airportService.saveAirport(airport);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/airports/{id}")
    public ResponseEntity<?> bringAirportById(@PathVariable Integer id)
    {
        return ResponseEntity.ok(this.airportService.findAirportById(id));
    }

    @GetMapping(value = "/airports")
    public ResponseEntity<?> bringTop20AirportsByName(@RequestParam String name)
    {
        return ResponseEntity.ok(this.airportService.findTop20AirportsMatchByName(name));
    }
}
