package com.gc.reactive.app.flight.booking.domain.vos;

import com.gc.reactive.app.flight.booking.presenter.dto.request.CreateBookingDto;

import java.util.Set;
import java.util.stream.Collectors;

public record CreateBookingCommand(
        Integer flightId,
        Set<PassengerData> passengers,
        PaymentData payment,
        ContactData contact)
{
    public static CreateBookingCommand from(CreateBookingDto createBookingDto)
    {
        Set<PassengerData> passengersData = createBookingDto.passengers().stream()
                .map(passenger -> new PassengerData(
                        passenger.firstName(),
                        passenger.lastName(),
                        new Document(passenger.document().documentType(), passenger.document().documentNumber()),
                        passenger.birthDate()))
                .collect(Collectors.toSet());

        return new CreateBookingCommand(
                createBookingDto.flightId(),
                passengersData,
                new PaymentData(createBookingDto.payment().cardToken()),
                new ContactData(createBookingDto.contact().email(),
                        createBookingDto.contact().phoneNumber(),
                        createBookingDto.contact().firstName(),
                        createBookingDto.contact().lastName())
        );
    }
}
