package com.gc.reactive.app.flight.booking.domain.models;

import com.gc.reactive.app.flight.booking.domain.vos.ContactData;
import com.gc.reactive.app.flight.booking.domain.vos.PnrData;
import com.gc.reactive.app.flight.booking.utils.enums.BookingStatus;
import com.gc.reactive.app.flight.booking.utils.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Booking
{
    private Integer flightId;
    private PnrData pnr;
    private BookingStatus bookingStatus;
    private ContactData contact;
    private PaymentStatus paymentStatus;
}
