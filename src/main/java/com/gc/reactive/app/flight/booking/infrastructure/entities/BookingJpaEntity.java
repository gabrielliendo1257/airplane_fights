package com.gc.reactive.app.flight.booking.infrastructure.entities;

import com.gc.reactive.app.flight.booking.utils.enums.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name = "bookings")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookingJpaEntity
{
    @Id
    @Column(updatable = false, unique = true, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    @Embedded
    private ContactEmbeddable contact;

    @Column(name = "id_flight", nullable = false, length = 10, updatable = false)
    private Integer flightId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
