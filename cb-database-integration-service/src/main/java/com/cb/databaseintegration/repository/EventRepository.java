package com.cb.databaseintegration.repository;

import com.cb.databaseintegration.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

    Optional<Event> findByDataProviderId(Integer dataProviderId);
}
