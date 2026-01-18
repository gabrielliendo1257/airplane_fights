package com.gc.reactive.app.flight.flight.infrastructure.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig
{
    SecurityFilterChain securityFilterChain(HttpSecurity http)
    {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(requestAuthorization -> requestAuthorization
                        .requestMatchers(HttpMethod.POST, "/api/v1/flights").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.GET, "/api/v1/flights/test").hasRole("CUSTOMER")
                        .anyRequest().denyAll()
                );

        return http.build();
    }

}
