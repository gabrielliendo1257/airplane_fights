package com.gcorp.service.app.itineraryservice.infrastructure.repository;

import com.gcorp.service.app.itineraryservice.domain.models.ItineraryModel;
import com.gcorp.service.app.itineraryservice.domain.ports.ItineraryRepository;
import com.gcorp.service.app.itineraryservice.infrastructure.entities.ItineraryJpaEntity;
import com.gcorp.service.app.itineraryservice.infrastructure.mapper.ItineraryMapper;
import org.springframework.stereotype.Service;

@Service
public class ItineraryRepositoryImpl implements ItineraryRepository
{
    private final ItineraryPostgresSqlRepository postgresSqlItineraryRepository;
    private final ItineraryMapper itineraryMapper;

    public ItineraryRepositoryImpl(
            ItineraryPostgresSqlRepository postgresSqlItineraryRepository,
            ItineraryMapper itineraryMapper
    )
    {
        this.postgresSqlItineraryRepository = postgresSqlItineraryRepository;
        this.itineraryMapper = itineraryMapper;
    }

    @Override
    public ItineraryModel save(ItineraryModel itinerary)
    {
        ItineraryJpaEntity itineraryEntity = this.postgresSqlItineraryRepository.save(
                this.itineraryMapper.toEntity(itinerary)
        );

        return itineraryMapper.toModel(itineraryEntity);
    }
}
