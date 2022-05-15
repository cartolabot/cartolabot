package com.cb.cartolascraping.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Atletas",
        "Clubes",
        "Posicoes",
        "Versao"
})
public class Cache {

    @JsonProperty("Atletas")
    public Boolean atletas;
    @JsonProperty("Clubes")
    public Boolean clubes;
    @JsonProperty("Posicoes")
    public Boolean posicoes;
    @JsonProperty("Versao")
    public String versao;
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
