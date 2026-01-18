package com.gc.reactive.app.flight.flight.infrastructure.persistence.segments;

import java.time.LocalDateTime;

import com.gc.reactive.app.flight.flight.infrastructure.persistence.flight.FlightJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "flights_segments")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightSegmentJpaEntity
{
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private FlightJpaEntity flight;

    private String airportNameOrigin;

    private String airportNameDestination;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;
}
