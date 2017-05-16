package com.teksystems.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * Jersey implementation.
 */
public class JerseyRestClient implements RestClient {
    public String queryJira() {
        Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter("gausner@list.ru", "12345678"));

        WebResource webResource = client.resource("https://tekcloud.atlassian.net/rest/api/2/search?jql=project+in+(TPSVC)+AND+issuetype+in+(%22Change+Request%22,+%22Customer+Rule%22,+Defect,+Dictionary,+Project,+%22QA+Testing%22,+Release,+%22Technical+Coding+/+Config%22,+%22QA+Task%22)+AND+created+%3E%3D+2017-04-01+ORDER+BY+created+DESC&startAt=0&maxResults=1001&fields=key,issuetype,status,priority,resolution,created,updated,lastViewed,resolutiondate,resolved,components,customfield_10303,customfield_10307,customfield_10304,customfield_10308,customfield_10306,customfield_10305,customfield_10400,customfield_10201");

        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        return response.getEntity(String.class);
    }
}
