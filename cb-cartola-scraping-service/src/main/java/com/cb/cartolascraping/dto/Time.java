package com.cb.cartolascraping.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Time {

    @JsonProperty("ID")
    public Integer id;
    @JsonProperty("N")
    public String n;
    @JsonProperty("P")
    public Double p;
    @JsonProperty("PM")
    public Double pm;
    @JsonProperty("PR")
    public Double pr;
    @JsonProperty("ES")
    public String es;
    @JsonProperty("SL")
    public String sl;
    @JsonProperty("PA")
    public Double pa;
    @JsonProperty("QP")
    public Integer qp;
    @JsonProperty("NC")
    public String nc;
    @JsonProperty("SC")
    public List<Object> sc = null;
    @JsonProperty("EE")
    public List<Ee> ee = null;
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