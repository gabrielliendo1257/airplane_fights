package com.gcorp.service.app.providers.airport.exceptions;

public class AirportDoesNotExistException extends RuntimeException
{
    public AirportDoesNotExistException(String message)
    {
        super(message);
    }
}
