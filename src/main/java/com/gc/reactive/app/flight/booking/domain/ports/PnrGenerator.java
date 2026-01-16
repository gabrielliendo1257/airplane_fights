package com.gc.reactive.app.flight.booking.domain.ports;

import com.gc.reactive.app.flight.booking.domain.vos.PnrData;

public interface PnrGenerator
{
    PnrData generatePnr();
}
