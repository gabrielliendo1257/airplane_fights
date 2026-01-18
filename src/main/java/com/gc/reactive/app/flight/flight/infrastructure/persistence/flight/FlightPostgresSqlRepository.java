package com.gc.reactive.app.flight.flight.infrastructure.persistence.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightPostgresSqlRepository extends JpaRepository<FlightJpaEntity, Integer>
{
}
