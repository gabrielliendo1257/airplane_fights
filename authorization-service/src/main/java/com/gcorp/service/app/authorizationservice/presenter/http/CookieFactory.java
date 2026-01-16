package com.gcorp.service.app.authorizationservice.presenter.http;

import com.gcorp.service.app.authorizationservice.presenter.dto.JwtAccessTokenDto;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class CookieFactory
{
    public ResponseCookie accessToken(JwtAccessTokenDto jwtAccessToken)
    {
        return ResponseCookie.from(
                        "access_token",
                        jwtAccessToken.accessToken()
                )
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .path("/")
                .maxAge(Duration.ofMinutes(15))
                .build();
    }

    public ResponseCookie refreshToken(JwtAccessTokenDto jwtAccessToken)
    {
        return ResponseCookie.from(
                        "refresh_token",
                        jwtAccessToken.refreshToken()
                )
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .path("/")
                .maxAge(Duration.ofMinutes(15))
                .build();
    }
}
