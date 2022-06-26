package com.cb.dfintegration.inbound;

import com.cb.dfintegration.dto.WppMessageDto;
import com.cb.dfintegration.service.DialogFlowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    private DialogFlowService dialogFlowService;

    public static final String TOPIC_WPP_MSG = "wpp.msg";

    @KafkaListener(topics = TOPIC_WPP_MSG, groupId = "cb-group",
            containerFactory = "messageLiveEventKafkaListenerContainerFactory")
    public void listenMatchEventTopic(List<WppMessageDto> messages) {
        log.info("Received messages in topic {}: {}", TOPIC_WPP_MSG, messages.toString());

        dialogFlowService.detectIntent();

    }
}
