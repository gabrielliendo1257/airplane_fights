package com.gcorp.service.app.providers.aircraft.infrastructure.service;

import com.gcorp.service.app.providers.aircraft.exceptions.AircraftDoesNotExistException;
import com.gcorp.service.app.providers.aircraft.infrastructure.entities.AirCraftJpaEntity;
import com.gcorp.service.app.providers.aircraft.infrastructure.repository.AirCraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<AirCraftJpaEntity> searchAirCraftsByRegistration(String register)
    {
        List<AirCraftJpaEntity> airCraftsEntities = this.airCraftRepository.findTop10ByRegistrationIgnoreCaseContaining(register);

        if (airCraftsEntities.isEmpty()) {
            throw new AircraftDoesNotExistException("Aircraft with register " + register + " does not exist");
        }

        return airCraftsEntities;
    }

    public void existsByRegistration(String register) {
        Boolean existsEntity = this.airCraftRepository.existsByRegistrationIgnoreCase(register);

        if (!existsEntity) {
            throw new AircraftDoesNotExistException("Aircraft with name " + register + " does not exist");
        }
    }
}
