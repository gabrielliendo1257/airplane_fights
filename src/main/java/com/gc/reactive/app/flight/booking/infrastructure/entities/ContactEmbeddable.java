package com.gc.reactive.app.flight.booking.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ContactEmbeddable
{
    @Column(name = "first_name", nullable = false, length = 50, unique = true)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(name = "phone_number", length = 50, unique = true)
    private String phoneNumber;
}
