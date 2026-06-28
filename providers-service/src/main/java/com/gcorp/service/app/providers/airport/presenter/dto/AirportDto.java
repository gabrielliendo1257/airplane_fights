package com.gcorp.service.app.providers.airport.presenter.dto;

import com.gcorp.service.app.providers.airport.enums.AirportType;
import com.gcorp.service.app.providers.airport.infrastructure.entities.AirportJpaEntity;

import java.io.Serializable;

/**
 * DTO for {@link AirportJpaEntity}
 */
public record AirportDto(
        Integer id,
        String name,
        String city,
        String country,
        String iataCode,
        String icaoCode,
        Double latitude,
        Double longitude,
        Integer elevationFeet,
        Integer gmtOffset,
        String dst,
        String timezone,
        AirportType type,
        String source) implements Serializable
{
}