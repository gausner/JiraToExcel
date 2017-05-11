package com.teksystems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Issues {
    /*
    issues is an array of js objects
     */
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
