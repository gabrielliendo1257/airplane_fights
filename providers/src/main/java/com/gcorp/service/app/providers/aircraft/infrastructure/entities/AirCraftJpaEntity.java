package com.gcorp.service.app.providers.aircraft.infrastructure.entities;

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
        name = "aircrafts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "registration")
        }
)
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AirCraftJpaEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Matrícula del avión (ej: OB-2154)
     */
    @Column(nullable = false, unique = true)
    private String registration;

    /**
     * Modelo (A320, B737)
     */
    @Column(nullable = false)
    private String model;

    /**
     * Capacidad total de asientos
     */
    @Column(name = "seat_capacity", nullable = false)
    private int seatCapacity;
}
