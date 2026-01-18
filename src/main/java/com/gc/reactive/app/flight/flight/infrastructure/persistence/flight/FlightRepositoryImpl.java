package com.gc.reactive.app.flight.flight.infrastructure.persistence.flight;

import com.gc.reactive.app.flight.flight.app.response.PageResult;
import com.gc.reactive.app.flight.flight.domain.exceptions.FlightNotFountException;
import com.gc.reactive.app.flight.flight.domain.models.AppPageRequest;
import com.gc.reactive.app.flight.flight.domain.models.Flight;
import com.gc.reactive.app.flight.flight.domain.ports.FlightRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageResult<Flight> findAllByPage(AppPageRequest pageRequest)
    {
        Pageable pageable = PageRequest.of(pageRequest.getPage(), pageRequest.getSize());

        Page<FlightJpaEntity> pageFlightEntity = this.flightPostgresSqlRepository.findAll(pageable);

        List<Flight> pageFlight = pageFlightEntity.getContent()
                .stream()
                .map(this.flightMapper::toDomain)
                .toList();

        return new PageResult<>(
                pageFlight,
                pageFlightEntity.getTotalElements(),
                pageRequest.getPage(),
                pageRequest.getSize()
        );
    }
}
