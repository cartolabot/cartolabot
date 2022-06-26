package com.cb.dfintegration.config;

import com.cb.dfintegration.dto.WppMessageDto;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.producer.group-id}")
    private String groupId;


    @Bean
    public ConsumerFactory<String, List<WppMessageDto>> messageWppConsumerFactory(){
        ObjectMapper om = new ObjectMapper();
        JavaType type = om.getTypeFactory().constructParametricType(List.class, WppMessageDto.class);
        return new DefaultKafkaConsumerFactory<>(getConfig(), new StringDeserializer(),
                new JsonDeserializer<>(type, om, false));
    }

    private Map<String, Object> getConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return config;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, List<WppMessageDto>> messageWppKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, List<WppMessageDto>> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(messageWppConsumerFactory());
        return factory;
    }
}
