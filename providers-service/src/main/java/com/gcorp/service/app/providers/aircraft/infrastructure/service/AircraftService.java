package com.gcorp.service.app.providers.aircraft.infrastructure.service;

import com.gcorp.service.app.providers.aircraft.exceptions.AircraftDoesNotExistException;
import com.gcorp.service.app.providers.aircraft.infrastructure.database.specs.AircraftSpec;
import com.gcorp.service.app.providers.aircraft.infrastructure.entities.AirCraftJpaEntity;
import com.gcorp.service.app.providers.aircraft.infrastructure.repository.AirCraftRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class AircraftService
{
    private final AirCraftRepository airCraftRepository;

    public AircraftService(AirCraftRepository airCraftRepository)
    {
        this.airCraftRepository = airCraftRepository;
    }

    public AirCraftJpaEntity getAirCraftByRegistration(String register)
    {
        return this.airCraftRepository.findByRegistration(register)
                .orElseThrow(() -> new AircraftDoesNotExistException("Aircraft with register " + register + " does not exist"));
    }

    public List<AirCraftJpaEntity> search(String model, String register, Integer page, Integer size)
    {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "registration"));
        Specification<AirCraftJpaEntity> aircraftSpec = where(AircraftSpec.hasModel(model)
                .and(AircraftSpec.hasRegistration(register)));

        List<AirCraftJpaEntity> aircraftResults = this.airCraftRepository.findAll(aircraftSpec, pageable).getContent();

        if (aircraftResults.isEmpty())
        {
            throw new AircraftDoesNotExistException("Aircraft with register " + register + " does not exist");
        }

        return aircraftResults;
    }
}
