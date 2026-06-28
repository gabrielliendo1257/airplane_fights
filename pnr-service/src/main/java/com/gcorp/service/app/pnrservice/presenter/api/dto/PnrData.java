package com.gcorp.service.app.pnrservice.presenter.api.dto;

import com.gcorp.service.app.pnrservice.domain.vos.ContactData;

public record DataPnr(
        String pnrCode,
        ContactData contact
) {}
