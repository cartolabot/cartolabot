package com.cb.databaseintegration.model;

import lombok.Data;

@Data
public class Team {

    private String id;
    private Integer dataProviderId;
    private String dataProvider;
    private String gender;
    private String name;
    private String nameCode;
    private Boolean national;
    private String shortName;
    private String slug;

}
