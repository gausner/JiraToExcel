package com.teksystems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by yshamne on 2017-05-11.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fields {
    @JsonProperty("issuetype")
    private IssueType issueType;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("priority")
    private Priority priority;

    @JsonProperty("resolution")
    private String resolution;

    @JsonProperty("lastViewed")
    private String lastViewed;

    @JsonProperty("created")
    private String created;

    @JsonProperty("updated")
    private String updated;

    /*
    Custom field (Customer(s))
     */
    @JsonProperty("customfield_11010")
    private List<Customer_s> customer_s;

    public IssueType getIssueType() {
        return issueType;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        if (priority == null) {
            priority = new Priority();
            priority.setName("");
        }
        return priority;
    }

    public String getResolution() {
        return emptyIfNull(resolution);
    }

    public String getLastViewed() {
        return emptyIfNull(lastViewed);
    }

    public String getCreated() {
        return emptyIfNull(created);
    }

    public String getUpdated() {
        return updated;
    }

    public Customer_s getCustomer_s() {
        return customer_s.get(0);
    }

    private String emptyIfNull(String value) {
        return value != null ? value : "";
    }
}
