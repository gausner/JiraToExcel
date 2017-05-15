package com.teksystems.deserialize;

import com.teksystems.datamodel.Root;

/**
 * Converts json to Java object.
 */
public interface JsonToJava {
    Root convert(String json);
}
