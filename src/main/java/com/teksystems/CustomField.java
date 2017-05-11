package com.teksystems;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yshamne on 2017-05-11.
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
