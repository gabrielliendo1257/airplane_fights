package com.gc.reactive.app.flight.booking.infrastructure.repository;

import com.gc.reactive.app.flight.booking.infrastructure.entities.BookingJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingDataRepository extends JpaRepository<BookingJpaEntity, Integer>
{
    Optional<BookingJpaEntity> findByContactLastNameAndCode(String lastName, String code);
}
