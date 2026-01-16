package com.gc.reactive.app.flight.passenger.infrastructure.repository;

import com.gc.reactive.app.flight.passenger.infrastructure.entities.PassengerJpaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerJpaRepository extends JpaRepository<PassengerJpaEntity, Integer>
{
}
