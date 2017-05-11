package com.teksystems;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yshamne on 2017-05-11.
 */
public class Field {
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
