package com.cb.cartolascraping.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status_cartola",
        "mensagem",
        "rodada_atual",
        "config"
})
public class StatusCartola {

    @JsonProperty("status_cartola")
    public Boolean statusCartola;
    @JsonProperty("mensagem")
    public String mensagem;
    @JsonProperty("rodada_atual")
    public Integer rodadaAtual;
    @JsonProperty("config")
    public Config config;
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
