package com.gc.reactive.app.flight.flight.infrastructure.persistence.flight;


import com.gc.reactive.app.flight.flight.infrastructure.persistence.segments.FlightSegmentJpaEntity;
import com.gc.reactive.app.flight.flight.utils.enums.FlightStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Table(name = "flights")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FlightJpaEntity
{
    @Id
    @Column(nullable = false, updatable = false, unique = true, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

    private Integer idAircraft;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<FlightSegmentJpaEntity> segments = new HashSet<>();
}
