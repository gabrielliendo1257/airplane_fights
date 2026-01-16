package com.gc.reactive.app.flight.flight.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(
        name = "airports",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "iata_code")
        }
)
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AirportJpaEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Código IATA (LIM, MAD, JFK)
     */
    @Column(name = "iata_code", nullable = false, length = 10, unique = true)
    private String iataCode;

    @Column(nullable = false, unique = true, length = 10)
    private String name;

    @Column(nullable = false, unique = true, length = 10)
    private String city;

    @Column(nullable = false, unique = true, length = 10)
    private String country;
}
