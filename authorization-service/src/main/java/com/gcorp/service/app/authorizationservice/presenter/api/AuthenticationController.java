package com.gcorp.service.app.authorizationservice.presenter.api;

import com.gcorp.service.app.authorizationservice.app.usecases.CodeExchangeUseCase;
import com.gcorp.service.app.authorizationservice.app.usecases.RefreshAuthUseCase;
import com.gcorp.service.app.authorizationservice.presenter.dto.AuthCodeDto;
import com.gcorp.service.app.authorizationservice.presenter.dto.JwtAccessTokenDto;
import com.gcorp.service.app.authorizationservice.presenter.dto.RefreshTokenDto;
import com.gcorp.service.app.authorizationservice.presenter.http.CookieFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "${authorization.env.api.path-base}")
public class AuthenticationController
{
    private final CookieFactory cookieFactory;
    private final CodeExchangeUseCase codeExchangeUseCase;
    private final RefreshAuthUseCase refreshAuthUseCase;

    public AuthenticationController(
            CookieFactory cookieFactory,
            CodeExchangeUseCase codeExchangeUseCase,
            RefreshAuthUseCase refreshAuthUseCase
    )
    {
        this.cookieFactory = cookieFactory;
        this.codeExchangeUseCase = codeExchangeUseCase;
        this.refreshAuthUseCase = refreshAuthUseCase;
    }

    @PostMapping(value = "/auth/cookie/exchange")
    public ResponseEntity<?> cookieTokenExchange(@RequestBody AuthCodeDto authCode)
    {
        JwtAccessTokenDto jwtAccessToken = this.codeExchangeUseCase.execute(authCode.code());

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, this.cookieFactory.accessToken(jwtAccessToken).toString())
                .header(HttpHeaders.SET_COOKIE, this.cookieFactory.refreshToken(jwtAccessToken).toString())
                .build();
    }

    @PostMapping(value = "/auth/refresh")
    public ResponseEntity<?> refreshTokenExchange(@RequestBody RefreshTokenDto refreshTokenDto)
    {
        return ResponseEntity.ok(this.refreshAuthUseCase.execute(refreshTokenDto.refreshToken()));
    }

    @PostMapping(value = "/auth/exchange")
    public ResponseEntity<?> tokenExchange(@RequestBody AuthCodeDto authCode)
    {
        return ResponseEntity.ok(this.codeExchangeUseCase.execute(authCode.code()));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/auth/me")
    public ResponseEntity<?> getMe()
    {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/auth/admin")
    public ResponseEntity<?> isAdmin()
    {
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
