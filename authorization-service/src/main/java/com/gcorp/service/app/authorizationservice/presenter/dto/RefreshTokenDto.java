package com.gcorp.service.app.authorizationservice.presenter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RefreshTokenDto(
        @JsonProperty(value = "refresh_token")
        String refreshToken)
{
}
