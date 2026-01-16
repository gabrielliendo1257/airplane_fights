package com.gc.reactive.app.flight.flight.infrastructure.repository;

import com.gc.reactive.app.flight.flight.domain.exceptions.FlightNotFountException;
import com.gc.reactive.app.flight.flight.domain.models.Flight;
import com.gc.reactive.app.flight.flight.domain.ports.FlightRepository;
import com.gc.reactive.app.flight.flight.infrastructure.entities.FlightJpaEntity;
import com.gc.reactive.app.flight.flight.infrastructure.mapper.FlightMapper;
import org.springframework.stereotype.Service;

@Service
public class FlightRepositoryImpl implements FlightRepository
{
    private final FlightPostgresSqlRepository flightPostgresSqlRepository;
    private final FlightMapper flightMapper;

    public FlightRepositoryImpl(FlightPostgresSqlRepository flightPostgresSqlRepository, FlightMapper flightMapper)
    {
        this.flightPostgresSqlRepository = flightPostgresSqlRepository;
        this.flightMapper = flightMapper;
    }

    @Override
    public Flight findById(Integer id)
    {
        FlightJpaEntity flightEntity = this.flightPostgresSqlRepository.findById(id)
                .orElseThrow(() -> new FlightNotFountException("Flight not fount"));
        return this.flightMapper.toDomain(flightEntity);
    }

    @Override
    public Flight save(Flight flight)
    {
        FlightJpaEntity createdFlight = this.flightPostgresSqlRepository.save(
                this.flightMapper.toEntity(flight)
        );
        return this.flightMapper.toDomain(createdFlight);
    }
}
