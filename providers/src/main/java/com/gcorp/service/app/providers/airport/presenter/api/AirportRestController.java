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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/airport")
public class AirportRestController
{
    private final AirportService airportService;

    public AirportRestController(AirportService airportService)
    {
        this.airportService = airportService;
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> saveAirport(@RequestBody AirportDto airport)
    {
        this.airportService.saveAirport(airport);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<?> getAirportById(@PathVariable(value = "id") Integer id)
    {
        return ResponseEntity.ok(this.airportService.getAirportById(id));
    }

    @GetMapping(value = "/iata/{iataCode}")
    public ResponseEntity<?> getAirportByIataCode(@PathVariable(value = "iataCode") String iataCode)
    {
        return ResponseEntity.ok(this.airportService.getAirportByIataCode(iataCode));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<?> getAirportsByName(@PathVariable(value = "name") String name)
    {
        return ResponseEntity.ok(this.airportService.searchAirportsByNameTop20(name));
    }
}
