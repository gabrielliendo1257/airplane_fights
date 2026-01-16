package com.gcorp.service.app.itineraryservice.domain.models;

import com.gcorp.service.app.itineraryservice.domain.vos.FlightSegment;
import jakarta.persistence.SecondaryTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryModel
{
    private Integer id;

    private Integer idFlight;

    private Set<FlightSegment> segments;
}
