package com.gcorp.service.app.pnrservice.domain.vos;

public record PassengerData
        (
                String firstName,
                String lastName,
                String ticketNumber,
                String seat
        )
{
}
