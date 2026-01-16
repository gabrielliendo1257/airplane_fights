package com.gcorp.service.app.authorizationservice.app.usecases;

import com.gcorp.service.app.authorizationservice.app.ports.OAuth2Service;
import com.gcorp.service.app.authorizationservice.presenter.dto.JwtAccessTokenDto;

public class RefreshAuthUseCase
{
    private final OAuth2Service<JwtAccessTokenDto> oAuth2Service;

    public RefreshAuthUseCase(OAuth2Service<JwtAccessTokenDto> oAuth2Service)
    {
        this.oAuth2Service = oAuth2Service;
    }

    public JwtAccessTokenDto execute(String code)
    {
        return this.oAuth2Service.refreshToken(code);
    }
}
