package com.gcorp.service.app.authorizationservice.module.conf;

import com.gcorp.service.app.authorizationservice.app.ports.OAuth2Service;
import com.gcorp.service.app.authorizationservice.app.usecases.CodeExchangeUseCase;
import com.gcorp.service.app.authorizationservice.app.usecases.RefreshAuthUseCase;
import com.gcorp.service.app.authorizationservice.presenter.dto.JwtAccessTokenDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorizationServiceConfiguration
{
    private final OAuth2Service<JwtAccessTokenDto> oAuth2Service;

    public AuthorizationServiceConfiguration(OAuth2Service<JwtAccessTokenDto> oAuth2Service)
    {
        this.oAuth2Service = oAuth2Service;
    }

    @Bean
    CodeExchangeUseCase codeExchangeUseCase()
    {
        return new CodeExchangeUseCase(this.oAuth2Service);
    }

    @Bean
    RefreshAuthUseCase refreshAuthUseCase()
    {
        return new RefreshAuthUseCase(this.oAuth2Service);
    }
}
