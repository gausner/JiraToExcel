package com.teksystems.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teksystems.datamodel.Root;

import java.io.IOException;

/**
 * Jackson impl
 */
public class JsonToJavaJacksonImpl implements JsonToJava {
    public Root convert(String json) {
        final ObjectMapper m = new ObjectMapper();
        Root issues = null;

        try {
            issues = m.readValue(json, Root.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize json: " + json);
        }
        return issues;
    }
}
