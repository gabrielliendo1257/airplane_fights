package com.gcorp.service.app.authorizationservice.security.conf;

import com.gcorp.service.app.authorizationservice.database.entities.CustomerEntity;
import com.gcorp.service.app.authorizationservice.database.repository.CustomerRepository;
import com.gcorp.service.app.authorizationservice.mapper.CustomerMapper;
import com.gcorp.service.app.authorizationservice.security.model.CustomerSecurity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig
{
    @Value("${authorization.env.frontend.host}")
    private String frontendHost;

    @Value("${authorization.env.jwk.uri}")
    private String jwkUrl;

    @Value("${authorization.env.api.path-base}")
    private String apiPathBase;

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Order(value = 2)
    SecurityFilterChain configuration(HttpSecurity http)
    {
        return http
                .cors(corsConfig -> corsConfig.configurationSource(this.corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer((resourceServer) -> resourceServer
                        .jwt(jwtConfig -> jwtConfig
                                .jwkSetUri(this.jwkUrl)))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, this.apiPathBase + "/hello").permitAll()

                        .requestMatchers(HttpMethod.POST, this.apiPathBase + "/auth/exchange").permitAll()
                        .requestMatchers(HttpMethod.GET, this.apiPathBase + "/auth/me").permitAll()
                        .requestMatchers(HttpMethod.GET, this.apiPathBase + "/auth/admin").permitAll()
                        .requestMatchers(HttpMethod.POST, this.apiPathBase + "/auth/refresh").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource()
    {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(List.of(this.frontendHost));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    @Bean
    AuthenticationManager authenticationProvider(PasswordEncoder passwordEncoder,
                                                 @Qualifier("userDetailService") UserDetailsService userDetailsService)
    {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    OAuth2TokenCustomizer<JwtEncodingContext> tokenCustomizer(
            @Value(value = "${spring.application.name}") String applicationName)
    {
        return (context) -> {
            var authentication = context.getPrincipal();

            if (authentication instanceof UsernamePasswordAuthenticationToken authenticationToken)
            {
                if (context.getTokenType() == OAuth2TokenType.ACCESS_TOKEN)
                {
                    List<String> roles = authenticationToken.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority)
                            .toList();

                    context.getClaims().audience(List.of(applicationName));
                    context.getClaims().subject(authenticationToken.getName());
                    context.getClaims().claim("roles", roles);
                }
            }
        };
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
    UserDetailsService userDetailService(CustomerRepository accountrepository, CustomerMapper accountMapper)
    {
        return (username) -> {
            CustomerEntity accountEntity = accountrepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Ususario no encontrado."));
            CustomerSecurity securityAccount = accountMapper.toSecurityAccount(accountEntity);
            log.info("SecurityAccount after mapper: {}", securityAccount);

            return securityAccount;
        };
    }
}
