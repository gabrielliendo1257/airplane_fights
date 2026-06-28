package com.gc.reactive.app.flight.booking.presenter.mapper;

import com.gc.reactive.app.flight.booking.app.response.ApiResponse;
import com.gc.reactive.app.flight.booking.app.response.ReservationResponse;
import com.gc.reactive.app.flight.booking.domain.models.Booking;
import com.gc.reactive.app.flight.booking.infrastructure.persistence.booking.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BookingControllerMapper
{
    private final BookingMapper bookingMapper;

    public BookingControllerMapper(BookingMapper bookingMapper)
    {
        this.bookingMapper = bookingMapper;
    }

    public ApiResponse<?> from(ReservationResponse response)
    {
        return new ApiResponse<>(
                true,
                this.bookingMapper.toEntity(booking),
                null
        );
    }
}
