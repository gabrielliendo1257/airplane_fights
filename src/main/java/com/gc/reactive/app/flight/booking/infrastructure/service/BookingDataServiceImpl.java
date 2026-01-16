package com.gc.reactive.app.flight.booking.infrastructure.service;

import com.gc.reactive.app.flight.booking.domain.exceptions.BookingNotFountException;
import com.gc.reactive.app.flight.booking.domain.models.Booking;
import com.gc.reactive.app.flight.booking.domain.ports.BookingDataService;
import com.gc.reactive.app.flight.booking.infrastructure.entities.BookingJpaEntity;
import com.gc.reactive.app.flight.booking.infrastructure.mapper.BookingMapper;
import com.gc.reactive.app.flight.booking.infrastructure.repository.BookingDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookingDataServiceImpl implements BookingDataService
{
    private final BookingDataRepository bookingDataRepository;
    private final BookingMapper bookingMapper;

    public BookingDataServiceImpl(BookingDataRepository bookingDataRepository, BookingMapper bookingMapper)
    {
        this.bookingDataRepository = bookingDataRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public Booking findByLastNameAndCode(String lastName, String code)
    {
        BookingJpaEntity bookingEntity = this.bookingDataRepository.findByContactLastNameAndCode(lastName, code)
                .orElseThrow(() -> new BookingNotFountException("Booking not fount with code: " + code));

        return this.bookingMapper.toModel(bookingEntity);
    }

    @Override
    public void deleteBooking(Booking booking)
    {
        BookingJpaEntity bookingEntity = this.bookingDataRepository.findByContactLastNameAndCode(booking.getContact().lastName(), booking.getPnr().code())
                .orElseThrow(() -> new BookingNotFountException("Booking not fount with code: " + booking.getPnr().code()));

        this.bookingDataRepository.delete(bookingEntity);
    }

    @Override
    public void saveBooking(Booking booking)
    {
        log.info("Save booking command: {}", booking);
        this.bookingDataRepository.save(this.bookingMapper.toEntity(booking));
    }
}
