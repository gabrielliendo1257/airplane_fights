package com.gc.reactive.app.flight.flight.domain.models;

import com.gc.reactive.app.flight.flight.domain.vos.FlightNumber;
import com.gc.reactive.app.flight.flight.domain.vos.FlightSegmentData;
import com.gc.reactive.app.flight.flight.utils.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Flight
{
    private Integer id;
    private FlightNumber number;
    private FlightStatus status;
    private Set<FlightSegmentData> segments;
}
