package com.gc.reactive.app.flight.booking.app.usecases;

import com.gc.reactive.app.flight.booking.app.response.FlightReservationResponse;
import com.gc.reactive.app.flight.booking.domain.models.Booking;
import com.gc.reactive.app.flight.booking.domain.vos.PnrData;
import com.gc.reactive.app.flight.booking.domain.ports.BookingRepository;
import com.gc.reactive.app.flight.booking.domain.ports.PnrGenerator;
import com.gc.reactive.app.flight.booking.domain.vos.CreateBookingCommand;
import com.gc.reactive.app.flight.booking.utils.enums.BookingStatus;
import com.gc.reactive.app.flight.booking.utils.enums.PaymentStatus;

public class BookingAFlihgtUseCase
{
    private final PnrGenerator pnrGenerator;
    private final BookingRepository bookingRepository;

    public BookingAFlihgtUseCase(PnrGenerator pnrGenerator, BookingRepository bookingRepository)
    {
        this.pnrGenerator = pnrGenerator;
        this.bookingRepository = bookingRepository;
    }

    public FlightReservationResponse execute(CreateBookingCommand command)
    {
        PnrData pnr = this.pnrGenerator.generatePnr();
        Booking booking = new Booking(
                command.flightId(),
                pnr,
                BookingStatus.PENDING,
                command.contact(),
                PaymentStatus.PAID
        );
        Booking resultBooking = this.bookingRepository.saveBooking(booking);

        return null;
    }
}
