package com.gc.reactive.app.flight.passenger.domain.exceptions;

public class PassengerNotFountException extends RuntimeException
{
    public PassengerNotFountException(String message)
    {
        super(message);
    }
}
