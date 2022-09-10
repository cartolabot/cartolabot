package com.cb.databaseintegration.repository;

import com.cb.databaseintegration.model.Event;
import com.cb.databaseintegration.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {

    Optional<Event> findByDataProviderId(Integer dataProviderId);

}
