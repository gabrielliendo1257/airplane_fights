package com.gc.reactive.app.flight.flight.infrastructure.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
