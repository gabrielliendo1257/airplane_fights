package com.gcorp.service.app.providers.aircraft.exceptions;

public class AircraftDoesNotExistException extends RuntimeException
{
    public AircraftDoesNotExistException(String message)
    {
        super(message);
    }
}
