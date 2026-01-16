package com.gcorp.service.app.authorizationservice;

import com.gcorp.service.app.authorizationservice.database.entities.CustomerEntity;
import com.gcorp.service.app.authorizationservice.database.repository.CustomerRepository;
import com.gcorp.service.app.authorizationservice.util.enums.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootApplication
public class AuthorizationServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AuthorizationServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner persistMovies(CustomerRepository customerRepository, PasswordEncoder passwordEncoder)
    {
        return args -> {
            CustomerEntity adminEntity = new CustomerEntity(null, "adminusername", passwordEncoder.encode("adminpassword"), Role.ADMIN);
            CustomerEntity authenticatedEntity = new CustomerEntity(null, "authusername", passwordEncoder.encode("authpassword"), Role.CUSTOMER);

            try
            {
                customerRepository.save(adminEntity);
                customerRepository.save(authenticatedEntity);
            } catch (Exception e)
            {
                log.info("Account does exist.");
            }
        };
    }
}
