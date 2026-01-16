package com.gcorp.service.app.providers.aircraft.infrastructure.repository;

import com.gcorp.service.app.providers.aircraft.infrastructure.entities.AirCraftJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirCraftRepository extends JpaRepository<AirCraftJpaEntity, Integer>
{
    Optional<AirCraftJpaEntity> findByRegistration(String registration);

    List<AirCraftJpaEntity> findTop10ByRegistrationIgnoreCaseContaining(String model);

    Boolean existsByRegistrationIgnoreCase(String model);
}