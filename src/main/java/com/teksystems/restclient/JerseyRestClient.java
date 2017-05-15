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

        WebResource webResource = client.resource("https://tekcloud.atlassian.net/rest/api/2/search?jql=project+in+(TPSVC,CSEL)+AND+issuetype+in+(%22Change+Request%22,+%22Customer+Rule%22,+Defect,+Dictionary,+Project,+%22QA+Testing%22,+Release,+%22Technical+Coding+/+Config%22,+%22QA+Task%22)+AND+created+%3E%3D+2017-04-01+ORDER+BY+created+DESC&startAt=0&maxResults=1000&fields=key,issuetype,status,priority,resolution,created,updated,lastViewed,resolutiondate,resolved,components,customfield_11010,customfield_15411,customfield_19611,customfield_10057,customfield_10056,customfield_15210,customfield_14018,customfield_11712");
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        return response.getEntity(String.class);
    }
}
