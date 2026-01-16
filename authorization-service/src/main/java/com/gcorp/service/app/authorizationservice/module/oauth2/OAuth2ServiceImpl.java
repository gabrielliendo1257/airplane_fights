package com.gcorp.service.app.authorizationservice.module.oauth2;

import com.gcorp.service.app.authorizationservice.app.ports.OAuth2Service;
import com.gcorp.service.app.authorizationservice.presenter.dto.JwtAccessTokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OAuth2ServiceImpl implements OAuth2Service<JwtAccessTokenDto>
{
    @Value("${authorization.env.oauth2.redirect}")
    private String oAuth2RedirectUrl;

    @Value(value = "${authorization.env.api.public-url}")
    private String publicUrl;

    @Value("${authorization.env.jwk.uri}")
    private String jwkUri;

    private final RestTemplate restTemplate;

    public OAuth2ServiceImpl(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public JwtAccessTokenDto exchange(String code)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("app-flight", "super-secret");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("code", code);
        map.add("redirect_uri", this.oAuth2RedirectUrl);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        return this.restTemplate.exchange(
                this.publicUrl + "/oauth2/token",
                HttpMethod.POST,
                request,
                JwtAccessTokenDto.class
        ).getBody();
    }

    @Override
    public JwtAccessTokenDto refreshToken(String refreshToken)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth("app-flight", "super-secret");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("refresh_token", refreshToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        return this.restTemplate.exchange(
                this.publicUrl + "/oauth2/token",
                HttpMethod.POST,
                request,
                JwtAccessTokenDto.class
        ).getBody();
    }
}
