package com.gc.reactive.app.flight.booking.infrastructure.mapper;

import com.gc.reactive.app.flight.booking.domain.models.Booking;
import com.gc.reactive.app.flight.booking.infrastructure.entities.BookingJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {ContactMapper.class}
)
public interface BookingMapper
{
    @Mapping(
            target = "code",
            expression = "java( booking.getPnr().code() )"
    )
    BookingJpaEntity toEntity(Booking booking);

    Booking toModel(BookingJpaEntity bookingJpaEntity);
}
