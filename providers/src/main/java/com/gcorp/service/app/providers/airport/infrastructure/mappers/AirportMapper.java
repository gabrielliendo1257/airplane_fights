package com.gcorp.service.app.providers.airport.infrastructure.mappers;

import com.gcorp.service.app.providers.airport.infrastructure.entities.AirportJpaEntity;
import com.gcorp.service.app.providers.airport.presenter.dto.AirportDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AirportMapper
{
    AirportJpaEntity toEntity(AirportDto airportDto);

    AirportDto toDto(AirportJpaEntity airportJpaEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AirportJpaEntity partialUpdate(AirportDto airportDto, @MappingTarget AirportJpaEntity airportJpaEntity);
}