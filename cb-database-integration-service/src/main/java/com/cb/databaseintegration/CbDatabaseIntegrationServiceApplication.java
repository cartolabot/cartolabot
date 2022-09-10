package com.cb.databaseintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.cb.databaseintegration.repository")
public class CbDatabaseIntegrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbDatabaseIntegrationServiceApplication.class, args);
    }

}
