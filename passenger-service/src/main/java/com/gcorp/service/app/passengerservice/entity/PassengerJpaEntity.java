package com.gcorp.service.app.passengerservice.infrastructure.persistence.passenger;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "passengers")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PassengerJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "document_number", nullable = false, length = 20)
    private String documentNumber;
}
