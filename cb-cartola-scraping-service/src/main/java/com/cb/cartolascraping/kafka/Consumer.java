package com.cb.cartolascraping.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

public class Consumer {

    public static final String TOPIC_MATCH_EVENT = "match.event";

    @KafkaListener(topics = TOPIC_MATCH_EVENT, groupId = "cb-group")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
