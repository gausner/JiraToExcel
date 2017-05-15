package com.teksystems.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.teksystems.datamodel.Component;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Components {
    /*
    issues is an array of js objects
     */
    @JsonProperty("components")
    private List<Component> components;

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        return "StateResponse [components=" + components + "]";
    }
}
