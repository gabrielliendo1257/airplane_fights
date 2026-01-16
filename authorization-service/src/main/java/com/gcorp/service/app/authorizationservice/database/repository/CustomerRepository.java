package com.gcorp.service.app.authorizationservice.database.repository;

import com.gcorp.service.app.authorizationservice.database.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>
{
    Optional<CustomerEntity> findByUsername(String username);
}
