package com.gc.reactive.app.flight.booking.infrastructure.config.module;

import com.gc.reactive.app.flight.booking.domain.vos.PnrData;
import com.gc.reactive.app.flight.booking.domain.ports.BookingDataService;
import com.gc.reactive.app.flight.booking.domain.ports.PnrGenerator;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RandomPnrGenerator implements PnrGenerator
{
    private final BookingDataService bookingDataService;

    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int PNR_LENGTH = 6;

    public RandomPnrGenerator(BookingDataService bookingDataService)
    {
        this.bookingDataService = bookingDataService;
    }

    @Override
    public PnrData generatePnr()
    {
        SecureRandom random = new SecureRandom();
        StringBuilder pnr = new StringBuilder(PNR_LENGTH);

        for (int i = 0; i < PNR_LENGTH; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            pnr.append(CHAR_POOL.charAt(index));
        }

        return new PnrData(pnr.toString());
    }
}
