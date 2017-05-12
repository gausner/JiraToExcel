package com.teksystems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
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
    private Resolution resolution;

    @JsonProperty("lastViewed")
    private String lastViewed;

    @JsonProperty("created")
    private String created;

    @JsonProperty("updated")
    private String updated;

    @JsonProperty("resolved")
    private String resolved;


    /*
    Custom field (Customer(s))
     */
    @JsonProperty("customfield_11010")
    private List<Customer_s> customer_s;

    /*
    Custom field (Product / Version)
     */
    @JsonProperty("customfield_15210")
    private ProductVersion productVersion;

    /*
    Custom field (Product / Version)
    */
    @JsonProperty("customfield_14018")
    private ReleaseStatus releaseStatus;



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

    public Resolution getResolution() {
        if (resolution == null) {
            resolution = new Resolution();
            resolution.setName("");
        }
        return resolution;
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

    public String getResolved() {
        return resolved;
    }

    public Customer_s getCustomer_s() {
        if(customer_s == null){
            customer_s = new ArrayList<Customer_s>();
            customer_s.add(new Customer_s()) ;
            customer_s.get(0).setValue("");
        }
        return customer_s.get(0);
    }

    public ProductVersion getProductVersion() {
        return productVersion;
    }

    public ReleaseStatus getReleaseStatus() {
        return releaseStatus;
    }

    
    private String emptyIfNull(String value) {
        return value != null ? value : "";
    }
}
