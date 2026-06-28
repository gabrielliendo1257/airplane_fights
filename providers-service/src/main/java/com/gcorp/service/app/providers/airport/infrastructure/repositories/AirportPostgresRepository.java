package com.gcorp.service.app.providers.airport.infrastructure.repositories;

import com.gcorp.service.app.providers.airport.infrastructure.entities.AirportJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportPostgresRepository extends JpaRepository<AirportJpaEntity, Integer>
{
    Optional<AirportJpaEntity> findByIataCode(String iataCode);

    List<AirportJpaEntity> findTop20ByNameIgnoreCaseContaining(String name);
}