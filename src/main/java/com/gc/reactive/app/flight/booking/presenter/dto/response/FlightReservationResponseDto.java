package com.gc.reactive.app.flight.booking.presenter.dto.response;

public record ResponseFlightReservation(
        String fullName,
        String pnr,
        String seatNumber,
        String seatType,
        AirportDto departureAirport,
        AirportDto arrivalAirport
)
{
}
