package com.gcorp.service.app.providers.aircraft.infrastructure.advisor;

import com.gcorp.service.app.providers.aircraft.exceptions.AircraftDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AircraftExceptionHandler
{
    @ExceptionHandler(value = AircraftDoesNotExistException.class)
    public ResponseEntity<?> handlingNullEntity(AircraftDoesNotExistException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
