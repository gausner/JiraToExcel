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

    @JsonProperty("components")
    private List<Component> components;
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
    Custom field (Default Component)
     */
    @JsonProperty("customfield_15411")
    private List<DefaultComponents> defaultComponents;

    /*
    Custom field (Product / Version)
    */
    @JsonProperty("customfield_14018")
    private ReleaseStatus releaseStatus;

    /*
    Custom field (Injection Point)
    */
    @JsonProperty("customfield_10056")
    private InjectionPoint injectionPoint;

    /*
    Custom field (Detection Point)
    */
    @JsonProperty("customfield_10057")
    private DetectionPoint detectionPoint;

    /*
    Custom field (Defect Type)
    */
    @JsonProperty("customfield_19611")
    private DefectType defectType;

    /*
    Custom field (Root Cause Analysis)
    */
    @JsonProperty("customfield_11712")
    private RootCauseAnalysis rootCauseAnalysis;


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

    public Component getComponent() {
        if(components == null){
            components = new ArrayList<Component>();
            components.add(new Component()) ;
            components.get(0).setValue("");
        }
        return components.get(0);
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
        if (productVersion == null) {
            productVersion.setValue("");
        }
        return productVersion;
    }

    public DefaultComponents getDefaultComponents() {
        if(defaultComponents == null){
            defaultComponents = new ArrayList<DefaultComponents>();
            defaultComponents.add(new DefaultComponents()) ;
            defaultComponents.get(0).setValue("");
        }
        return defaultComponents.get(0);
    }

    public ReleaseStatus getReleaseStatus() {
        if (releaseStatus == null) {
            releaseStatus.setValue("");
        }
        return releaseStatus;
    }

    public InjectionPoint getInjectionPoint() {
        if (injectionPoint == null) {
            injectionPoint.setValue("");
        }
        return injectionPoint;
    }

    public DetectionPoint getDetectionPoint() {
        if (detectionPoint == null) {
            detectionPoint.setValue("");
        }
        return detectionPoint;
    }

    public DefectType getDefectType() {
        if (defectType == null) {
            defectType.setValue("");
        }
        return defectType;
    }

    public RootCauseAnalysis getRootCauseAnalysis() {
        if (rootCauseAnalysis == null) {
            rootCauseAnalysis.setValue("");
        }
        return rootCauseAnalysis;
    }

    private String emptyIfNull(String value) {
        return value != null ? value : "";
    }
}
