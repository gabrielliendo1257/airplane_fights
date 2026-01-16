package com.gcorp.service.app.providers.airport.infrastructure.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizationConfig -> authorizationConfig
                        .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .oauth2ResourceServer((resourceConfig) -> resourceConfig
                        .jwt(Customizer.withDefaults())
                );

        return http.build();
    }

    @Bean
    JwtAuthenticationConverter authenticationConverter()
    {
        var jwtConverter = new JwtGrantedAuthoritiesConverter();
        jwtConverter.setAuthorityPrefix("");
        jwtConverter.setAuthoritiesClaimName("roles");

        var jwtAuthConverter = new JwtAuthenticationConverter();
        jwtAuthConverter.setJwtGrantedAuthoritiesConverter(jwtConverter);

        return jwtAuthConverter;
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer()
    {
        return (web) -> web.ignoring().requestMatchers("/h2-console/**");
    }
}
