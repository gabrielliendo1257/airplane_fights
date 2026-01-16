package com.gcorp.service.app.authorizationservice.app.ports;

import com.gcorp.service.app.authorizationservice.presenter.dto.JwtAccessTokenDto;

public interface OAuth2Service<T>
{
    T exchange(String code);

    JwtAccessTokenDto refreshToken(String refreshToken);
}
