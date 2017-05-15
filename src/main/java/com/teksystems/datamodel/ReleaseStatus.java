package com.teksystems.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teksystems.datamodel.CustomField;

/**
 * Model for 'release status' object inside 'fields'
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseStatus extends CustomField {

}
