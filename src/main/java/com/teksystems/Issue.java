package com.teksystems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yshamne on 2017-05-11.
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
