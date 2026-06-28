package com.gc.reactive.app.flight.booking.domain.ports;

import com.gc.reactive.app.flight.booking.domain.models.Booking;

public interface BookingDataService
{
    Booking findByLastNameAndCode(String lastName, String code);

    void deleteBooking(Booking booking);

    void saveBooking(Booking booking);
}
