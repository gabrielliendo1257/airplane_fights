package com.gc.reactive.app.flight.passenger.domain.ports;

import com.gc.reactive.app.flight.flight.infrastructure.entities.FlightJpaEntity;
import com.gc.reactive.app.flight.passenger.infrastructure.entities.PassengerJpaEntity;

public interface PassengerService
{
    void deletePassenger(PassengerJpaEntity passengerEntity, FlightJpaEntity flightEntity);

    void addFlight(PassengerJpaEntity passengerEntity, FlightJpaEntity flightEntity);

    void removeFlightAndSave(Integer passengerId, Integer flightId);

    PassengerJpaEntity findByPassengerId(Integer passengerId);

    void removeAllFlightsAndSave(PassengerJpaEntity passengerEntity);
}
