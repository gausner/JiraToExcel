package com.teksystems.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for properties inside the 'issues' object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    @JsonProperty("expand")
    private String expand;

    @JsonProperty("id")
    private String id;

    @JsonProperty("fields")
    private Fields fields;

    public String getId() {
        return id;
    }

    public Fields getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "StateResponse [expand=" + expand + "]";
    }
}
