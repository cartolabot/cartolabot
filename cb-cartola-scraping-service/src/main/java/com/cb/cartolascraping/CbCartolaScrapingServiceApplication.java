package com.cb.cartolascraping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {KafkaAutoConfiguration.class })
@EnableFeignClients
@EnableScheduling
public class CbCartolaScrapingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbCartolaScrapingServiceApplication.class, args);
    }

}
