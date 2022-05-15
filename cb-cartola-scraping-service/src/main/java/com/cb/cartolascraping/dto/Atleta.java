package com.cb.cartolascraping.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ID",
        "N",
        "PT",
        "C",
        "F"
})
public class Atleta {

    @JsonProperty("ID")
    public Integer id;
    @JsonProperty("N")
    public String n;
    @JsonProperty("PT")
    public Integer pt;
    @JsonProperty("C")
    public Integer c;
    @JsonProperty("F")
    public String f;
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
