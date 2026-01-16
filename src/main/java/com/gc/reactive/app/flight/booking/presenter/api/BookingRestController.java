package com.gc.reactive.app.flight.booking.presenter.api;

import com.gc.reactive.app.flight.booking.app.usecases.CancelBookingUseCase;
import com.gc.reactive.app.flight.booking.app.usecases.GenerateBookingUseCase;
import com.gc.reactive.app.flight.booking.domain.vos.CreateBookingCommand;
import com.gc.reactive.app.flight.booking.presenter.dto.request.CancelBookingDto;
import com.gc.reactive.app.flight.booking.presenter.dto.request.CreateBookingDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/booking")
public class BookingRestController
{
    private final CancelBookingUseCase cancelBookingUseCase;
    private final GenerateBookingUseCase generateBookingUseCase;

    public BookingRestController(CancelBookingUseCase cancelBookingUseCase, GenerateBookingUseCase generateBookingUseCase)
    {
        this.cancelBookingUseCase = cancelBookingUseCase;
        this.generateBookingUseCase = generateBookingUseCase;
    }

    @PostMapping(value = "/cancel")
    public ResponseEntity<?> cancelBooking(@RequestBody CancelBookingDto bookingIdDto)
    {
        this.cancelBookingUseCase.cancelBooking(bookingIdDto.lastName(), bookingIdDto.code());
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/generate")
    public ResponseEntity<?> generateBooking(@RequestBody CreateBookingDto createBooking)
    {
        log.info("Create booking command: {}", createBooking);
        this.generateBookingUseCase.generateBooking(CreateBookingCommand.from(createBooking));
        return ResponseEntity.ok().build();
    }
}
