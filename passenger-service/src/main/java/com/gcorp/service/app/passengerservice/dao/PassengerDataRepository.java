package com.gcorp.service.app.passengerservice.infrastructure.persistence.passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDataRepository extends JpaRepository<PassengerJpaEntity, Integer> {
}
