package com.teksystems.restclient;

/**
 * Rest client.
 */
public interface RestClient {
    String queryJira();

    int countRecords();

    String queryJira(String startAt);
}
