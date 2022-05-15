package com.cb.cartolascraping.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Data {

    @JsonProperty("sem_capitao")
    public Boolean semCapitao;
    @JsonProperty("Atletas")
    public List<Atleta> atletas = null;
    @JsonProperty("Posicoes")
    public List<Posico> posicoes = null;
    @JsonProperty("Times")
    public List<Time> times = null;
    @JsonProperty("Cache")
    public Cache cache;
    @JsonProperty("StatusCartola")
    public StatusCartola statusCartola;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}