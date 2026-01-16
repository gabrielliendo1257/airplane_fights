package com.gc.reactive.app.flight.passenger.domain.models;

import com.gc.reactive.app.flight.flight.domain.models.Flight;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PassengerModel
{
    private Integer id;
    private String firstName;
    private String lastName;
    private StatePassenger statePassenger;
    private Set<Flight> flights = new HashSet<>();
}
