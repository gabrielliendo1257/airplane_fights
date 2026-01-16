package com.gc.reactive.app.flight.passenger.infrastructure.entities;

import com.gc.reactive.app.flight.booking.utils.enums.DocumentType;
import jakarta.persistence.Column;
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

import java.time.LocalDateTime;

@Table(name = "passengers")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PassengerJpaEntity
{
    @Id
    @Column(nullable = false, updatable = false, unique = true, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "document_type", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "document_number", nullable = false, length = 8)
    private String documentNumber;

    @Column(name = "birth_date", nullable = false, length = 20)
    private LocalDateTime birthDate;

    private Integer bookingId;
}
