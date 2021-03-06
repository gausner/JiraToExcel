package com.teksystems.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Root json object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {

    @JsonProperty("issues")
    private List<Issue> issues;

    public List<Issue> getIssues() {
        return issues;
    }

    @Override
    public String toString() {
        return "StateResponse [issues=" + issues + "]";
    }
}
