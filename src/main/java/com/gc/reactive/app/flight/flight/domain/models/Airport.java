package com.gc.reactive.app.flight.flight.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport
{
    String iataCode;
    String name;
    String city;
    String country;
}
