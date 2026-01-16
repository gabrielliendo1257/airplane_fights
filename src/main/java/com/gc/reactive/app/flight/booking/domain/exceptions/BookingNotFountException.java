package com.gc.reactive.app.flight.booking.domain.exceptions;

public class BookingNotFountException extends RuntimeException
{
    public BookingNotFountException(String message)
    {
        super(message);
    }
}
