package com.cb.databaseintegration.model.kafka;

import com.cb.databaseintegration.model.Team;
import lombok.Data;

@Data
public class MessageScheduledEvent {

    private String dataProvider;
    private Integer dataProviderId;
    private Integer startTimestamp;
    private String slug;
    private Team homeTeam;
    private Team awayTeam;
}
