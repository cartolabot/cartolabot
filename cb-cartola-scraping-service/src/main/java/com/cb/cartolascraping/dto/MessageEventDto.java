package com.cb.cartolascraping.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MessageEventDto {

    private EventEnum event;
    private String teamHome;
    private String teamAway;
    private String scoreHome;
    private String scoreAway;
    private String min;
    private String goalPlayer;
    private String assistPlayer;
    private String cardPlayer;

}
