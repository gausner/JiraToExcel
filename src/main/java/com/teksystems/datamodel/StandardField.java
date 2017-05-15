package com.teksystems.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model for standard field
 */
public class StandardField {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
