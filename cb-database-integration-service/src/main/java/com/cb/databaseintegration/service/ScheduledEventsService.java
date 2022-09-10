package com.cb.databaseintegration.service;

import com.cb.databaseintegration.model.Event;
import com.cb.databaseintegration.model.Team;
import com.cb.databaseintegration.model.kafka.MessageScheduledEvent;
import com.cb.databaseintegration.repository.EventRepository;
import com.cb.databaseintegration.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledEventsService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TeamRepository teamRepository;

    private void temp() {

        Team awayTeam = new Team();
        awayTeam.setDataProviderId(2829);
        awayTeam.setDataProvider("sofascore");
        awayTeam.setName("Real Madrid");
        awayTeam.setSlug("real-madrid");
        awayTeam.setShortName("Real Madrid");
        awayTeam.setNameCode("RMD");
        awayTeam.setNational(false);

        Team homeTeam = new Team();
        homeTeam.setDataProviderId(2352);
        homeTeam.setDataProvider("sofascore");
        homeTeam.setName("Celtic");
        homeTeam.setSlug("celtic");
        homeTeam.setShortName("Celtic");
        homeTeam.setNameCode("CEL");
        homeTeam.setNational(false);

        MessageScheduledEvent messageScheduledEvent = new MessageScheduledEvent();
        messageScheduledEvent.setHomeTeam(homeTeam);
        messageScheduledEvent.setAwayTeam(awayTeam);
        messageScheduledEvent.setSlug("real-madrid-celtic");
        messageScheduledEvent.setStartTimestamp(1662490800);
        messageScheduledEvent.setDataProviderId(10640479);

        processMessages(List.of(messageScheduledEvent));

    }

    public void processMessages(List<MessageScheduledEvent> messages) {
        messages.forEach(message -> {
            saveTeams(message);
            saveEvent(message);
        });
    }

    private void saveEvent(MessageScheduledEvent message) {
        Event event = new Event();
        event.setHomeTeam(message.getHomeTeam());
        event.setAwayTeam(message.getAwayTeam());
        event.setDataProviderId(message.getDataProviderId());
        event.setStartTimestamp(message.getStartTimestamp());
        event.setDataProvider(message.getDataProvider());

        eventRepository.findByDataProviderId(message.getDataProviderId()).ifPresent(existingEvent ->
                event.setId(existingEvent.getId())
        );

        eventRepository.save(event);
    }

    private void saveTeams(MessageScheduledEvent message) {
        teamRepository.findByDataProviderId(message.getHomeTeam().getDataProviderId()).ifPresent(existingTeam ->
                message.getHomeTeam().setId(existingTeam.getId())
        );

        teamRepository.findByDataProviderId(message.getAwayTeam().getDataProviderId()).ifPresent(existingTeam ->
                message.getAwayTeam().setId(existingTeam.getId())
        );

        teamRepository.save(message.getHomeTeam());
        teamRepository.save(message.getAwayTeam());
    }
}
