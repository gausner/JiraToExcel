package com.teksystems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yshamne on 2017-05-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Component {

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
