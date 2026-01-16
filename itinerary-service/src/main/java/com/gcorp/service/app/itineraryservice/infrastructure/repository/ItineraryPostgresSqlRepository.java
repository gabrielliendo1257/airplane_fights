package com.gcorp.service.app.itineraryservice.infrastructure.repository;

import com.gcorp.service.app.itineraryservice.infrastructure.entities.ItineraryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryPostgresSqlRepository extends JpaRepository<ItineraryJpaEntity, Integer>
{
}
