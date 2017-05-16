package com.teksystems.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for the property 'fields' inside 'issue' object.
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
    @JsonProperty("customfield_10303")
    private Customer_s customer_s;

    /*
    Custom field (Product / Version)
     */
    @JsonProperty("customfield_10307")
    private ProductVersion productVersion;

    /*
    Custom field (Default Component)
     */
    @JsonProperty("customfield_10304")
    private DefaultComponents defaultComponents;

    /*
    Custom field (Product / Version)
    */
    @JsonProperty("customfield_10308")
    private ReleaseStatus releaseStatus;

    /*
    Custom field (Injection Point)
    */
    @JsonProperty("customfield_10306")
    private InjectionPoint injectionPoint;

    /*
    Custom field (Detection Point)
    */
    @JsonProperty("customfield_10305")
    private DetectionPoint detectionPoint;

    /*
    Custom field (Defect Type)
    */
    @JsonProperty("customfield_10400")
    private String defectType;

    /*
    Custom field (Root Cause Analysis)
    */
    @JsonProperty("customfield_10201")
    private String rootCauseAnalysis;



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
        if(components == null || components.size() == 0){
            components = new ArrayList<Component>();
            components.add(new Component()) ;
            components.get(0).setValue("");
        }
        return components.get(0);
    }

    public Customer_s getCustomer_s() {
        if (customer_s == null) {
            customer_s = new Customer_s();
            customer_s.setValue("");
        }
        return customer_s;
    }

    public ProductVersion getProductVersion() {
        if (productVersion == null) {
            productVersion = new ProductVersion();
            productVersion.setValue("");
        }
        return productVersion;
    }

    public DefaultComponents getDefaultComponents() {
        if (defaultComponents == null) {
            defaultComponents = new DefaultComponents();
            defaultComponents.setValue("");
        }
        return defaultComponents;
    }

    public ReleaseStatus getReleaseStatus() {
        if (releaseStatus == null) {
            releaseStatus = new ReleaseStatus();
            releaseStatus.setValue("");
        }
        return releaseStatus;
    }

    public InjectionPoint getInjectionPoint() {
        if (injectionPoint == null) {
            injectionPoint = new InjectionPoint();
            injectionPoint.setValue("");
        }
        return injectionPoint;
    }

    public DetectionPoint getDetectionPoint() {
        if (detectionPoint == null) {
            detectionPoint = new DetectionPoint();
            detectionPoint.setValue("");
        }
        return detectionPoint;
    }

    public String getDefectType() {
        return defectType;
    }

    public String getRootCauseAnalysis() {
        return rootCauseAnalysis;
    }

    private String emptyIfNull(String value) {
        return value != null ? value : "";
    }
}
