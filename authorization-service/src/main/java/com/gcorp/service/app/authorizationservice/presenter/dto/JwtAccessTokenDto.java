package com.gcorp.service.app.authorizationservice.presenter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JwtAccessTokenDto(
        @JsonProperty(value = "access_token")
        String accessToken,

        @JsonProperty(value = "refresh_token")
        String refreshToken,

        @JsonProperty(value = "token_type")
        String tokenType,

        @JsonProperty(value = "expires_in")
        Long expiresIn)
{
}
