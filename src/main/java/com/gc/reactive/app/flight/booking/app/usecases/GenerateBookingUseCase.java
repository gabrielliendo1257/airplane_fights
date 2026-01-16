package com.gc.reactive.app.flight.booking.app.usecases;

import com.gc.reactive.app.flight.booking.domain.models.Booking;
import com.gc.reactive.app.flight.booking.domain.vos.PnrData;
import com.gc.reactive.app.flight.booking.domain.ports.BookingDataService;
import com.gc.reactive.app.flight.booking.domain.ports.PnrGenerator;
import com.gc.reactive.app.flight.booking.domain.vos.CreateBookingCommand;
import com.gc.reactive.app.flight.booking.utils.enums.BookingStatus;
import com.gc.reactive.app.flight.booking.utils.enums.PaymentStatus;

public class GenerateBookingUseCase
{
    private final PnrGenerator pnrGenerator;
    private final BookingDataService bookingDataService;

    public GenerateBookingUseCase(PnrGenerator pnrGenerator, BookingDataService bookingDataService)
    {
        this.pnrGenerator = pnrGenerator;
        this.bookingDataService = bookingDataService;
    }

    public void generateBooking(CreateBookingCommand command)
    {
        PnrData pnr = this.pnrGenerator.generatePnr();
        Booking booking = new Booking(
                command.flightId(),
                pnr,
                BookingStatus.PENDING,
                command.contact(),
                PaymentStatus.PAID
        );
        this.bookingDataService.saveBooking(booking);
    }
}
