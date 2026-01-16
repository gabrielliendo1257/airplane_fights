package com.gc.reactive.app.flight.flight.infrastructure.repository;

import com.gc.reactive.app.flight.flight.infrastructure.entities.FlightJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightPostgresSqlRepository extends JpaRepository<FlightJpaEntity, Integer>
{
}
