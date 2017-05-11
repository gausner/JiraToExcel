package com.teksystems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import java.io.IOException;

/**
 * Created by yshamne on 2017-05-11.
 */
public class TestJira {
    public static void main(String[] args) {
        try {

            Client client = Client.create();
            client.addFilter(new HTTPBasicAuthFilter("gausner@list.ru", "12345678"));
            WebResource webResource = client.resource("https://tekcloud.atlassian.net/rest/api/2/search?jql=project+in(tek,new)&fields=*none");
            ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

            final ObjectMapper m = new ObjectMapper();
            JsonNode rootNode;
            try {
                rootNode = m.readTree(output);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }

            JsonNode resultNode = rootNode.findPath("issues");

            System.out.println("Json " + resultNode.size());

            for (int i = 0; i < resultNode.size(); i++) {
                String foundStateValue = resultNode.get(i).findPath("id").asText();
                System.out.println("id " + foundStateValue);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
