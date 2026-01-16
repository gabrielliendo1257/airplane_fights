package com.gc.reactive.app.flight.booking.app.usecases;

import com.gc.reactive.app.flight.booking.domain.models.Booking;
import com.gc.reactive.app.flight.booking.domain.ports.BookingDataService;

public class CancelBookingUseCase
{
    private final BookingDataService bookingDataService;

    public CancelBookingUseCase(BookingDataService bookingService)
    {
        this.bookingDataService = bookingService;
    }

    public void cancelBooking(String lastName, String code)
    {
        Booking booking = this.bookingDataService.findByLastNameAndCode(lastName, code);
        this.bookingDataService.deleteBooking(booking);
    }
}
