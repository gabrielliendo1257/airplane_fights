package com.gcorp.service.app.pnrservice.domain.vos;

public record SegmentData
        (
                String carrier,
                String flightNumber,
                String origin,
                String destination,
                String departure,
                String arrival,
                String classType,
                String seat,
                String status
        )
{
}
