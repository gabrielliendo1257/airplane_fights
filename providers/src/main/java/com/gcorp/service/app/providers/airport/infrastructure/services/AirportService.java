package com.gcorp.service.app.providers.airport.infrastructure.services;

import com.gcorp.service.app.providers.airport.exceptions.AirportDoesNotExistException;
import com.gcorp.service.app.providers.airport.infrastructure.entities.AirportJpaEntity;
import com.gcorp.service.app.providers.airport.infrastructure.mappers.AirportMapper;
import com.gcorp.service.app.providers.airport.infrastructure.repositories.AirportPostgresRepository;
import com.gcorp.service.app.providers.airport.presenter.dto.AirportDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AirportService
{
    private final AirportPostgresRepository airportRepository;
    private final AirportMapper airportMapper;

    public AirportService(AirportPostgresRepository airportRepository, AirportMapper airportMapper)
    {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public AirportJpaEntity saveAirport(AirportDto airport)
    {
        AirportJpaEntity airportEntity = this.airportMapper.toEntity(airport);
        return this.airportRepository.save(airportEntity);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public AirportJpaEntity getAirportById(Integer id)
    {
        return this.airportRepository.findById(id)
                .orElseThrow(() -> new AirportDoesNotExistException("Airport with id " + id + " does not exist."));
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public AirportJpaEntity getAirportByIataCode(String iataCode)
    {
        return this.airportRepository.findByIataCode(iataCode)
                .orElseThrow(() -> new AirportDoesNotExistException("Airport with iata " + iataCode + " does not exist."));
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<AirportJpaEntity> searchAirportsByNameTop20(String name)
    {
        List<AirportJpaEntity> airportEntities = this.airportRepository.findTop20ByNameIgnoreCaseContaining(name);

        if (airportEntities.isEmpty())
        {
            throw new AirportDoesNotExistException("Airport with name " + name + " does not exist.");
        }

        return airportEntities;
    }
}
