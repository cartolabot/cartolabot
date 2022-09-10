package com.cb.databaseintegration.inbound;

import com.cb.databaseintegration.model.kafka.MessageScheduledEvent;
import com.cb.databaseintegration.service.ScheduledEventsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    private ScheduledEventsService scheduledEventsService;

    public static final String TOPIC_SCHEDULED_EVENTS = "events.scheduled";

    @KafkaListener(topics = TOPIC_SCHEDULED_EVENTS, groupId = "cb-group",
            containerFactory = "messageScheduledEventsKafkaListenerContainerFactory")
    public void listenScheduledEventsTopic(List<MessageScheduledEvent> messages) {
        log.info("Received messages in group topic {} with {} of elements", TOPIC_SCHEDULED_EVENTS, messages.size());

        scheduledEventsService.processMessages(messages);
    }
}
