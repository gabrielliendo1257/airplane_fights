package com.gc.reactive.app.flight.booking.infrastructure.config.module;

import com.gc.reactive.app.flight.booking.app.usecases.CancelBookingUseCase;
import com.gc.reactive.app.flight.booking.app.usecases.GenerateBookingUseCase;
import com.gc.reactive.app.flight.booking.domain.ports.BookingDataService;
import com.gc.reactive.app.flight.booking.domain.ports.PnrGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingConfiguration
{
    private final BookingDataService bookingDataService;
    private final PnrGenerator pnrGenerator;

    public BookingConfiguration(BookingDataService bookingDataService, PnrGenerator pnrGenerator)
    {
        this.bookingDataService = bookingDataService;
        this.pnrGenerator = pnrGenerator;
    }

    @Bean
    CancelBookingUseCase cancelBookingUseCase()
    {
        return new CancelBookingUseCase(this.bookingDataService);
    }

    @Bean
    GenerateBookingUseCase generateBookingUseCase()
    {
        return new GenerateBookingUseCase(this.pnrGenerator, this.bookingDataService);
    }
}
