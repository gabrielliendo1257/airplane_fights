package com.gcorp.service.app.providers.aircraft.infrastructure.database.specs;

import com.gcorp.service.app.providers.aircraft.infrastructure.entities.AirCraftJpaEntity;
import org.springframework.data.jpa.domain.Specification;

public class AircraftSpec
{
    public static Specification<AirCraftJpaEntity> hasRegistration(String registration)
    {
        return (root, query, cb) -> {
            if (registration == null || registration.trim().isEmpty())
            {
                return null;
            }

            return cb.like(cb.lower(root.get("registration")), "%" + registration.toLowerCase() + "%");
        };
    }

    public static Specification<AirCraftJpaEntity> hasModel(String model)
    {
        return (root, query, cb) -> {
            if (model == null || model.trim().isEmpty())
            {
                return null;
            }

            return cb.like(cb.lower(root.get("model")), "%" + model.toLowerCase() + "%");
        };
    }
}
