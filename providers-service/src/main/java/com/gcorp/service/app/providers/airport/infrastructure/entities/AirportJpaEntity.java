package com.gcorp.service.app.providers.airport.infrastructure.entities;

import com.gcorp.service.app.providers.airport.enums.AirportType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Table(
        name = "airports",
        indexes = {
                @Index(name = "idx_airport_iata", columnList = "iata_code"),
                @Index(name = "idx_airport_icao", columnList = "icao_code"),
                @Index(name = "idx_airport_country", columnList = "country")
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
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id; // ID externo (OurAirports)

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "iata_code", length = 3, unique = true)
    private String iataCode;

    @Column(name = "icao_code", length = 4, unique = true)
    private String icaoCode;

    @Column(precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 6)
    private BigDecimal longitude;

    @Column(name = "elevation_ft")
    private Integer elevationFeet;

    @Column(name = "gmt_offset", precision = 4, scale = 2)
    private BigDecimal gmtOffset;

    @Column(name = "dst", length = 1)
    private String dst; // Y, N, U

    @Column(name = "timezone", nullable = false, length = 50)
    private String timezone;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 20)
    private AirportType type;

    @Column(name = "source", nullable = false, length = 50)
    private String source;
}