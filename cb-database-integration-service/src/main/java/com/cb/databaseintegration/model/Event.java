package com.cb.databaseintegration.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("event")
public class Event {

    @Id
    private String id;
    private String dataProvider;
    private Integer dataProviderId;
    private Integer startTimestamp;
    private String slug;
    private Team homeTeam;
    private Team awayTeam;

}
