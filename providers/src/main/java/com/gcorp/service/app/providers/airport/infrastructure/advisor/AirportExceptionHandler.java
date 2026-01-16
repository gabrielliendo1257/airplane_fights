package com.gcorp.service.app.providers.airport.infrastructure.advisor;

import com.gcorp.service.app.providers.airport.exceptions.AirportDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AirportExceptionHandler
{
    @ExceptionHandler(value = AirportDoesNotExistException.class)
    public ResponseEntity<?> handlingNullEntity(AirportDoesNotExistException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
