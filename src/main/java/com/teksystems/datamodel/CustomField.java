package com.teksystems.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for custom field
 */
public class CustomField {
    @JsonProperty("id")
    private String id;

    @JsonProperty("value")
    private String value;

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String name) {
        this.value = name;
    }
}
