package com.teksystems;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

/**
 * Created by yshamne on 2017-05-11.
 */
public class TestJira {
    public static void main(String[] args) {
        try {

            Client client = Client.create();
            client.addFilter(new HTTPBasicAuthFilter("gausner@list.ru", "12345678"));

            WebResource webResource = client.resource("https://tekcloud.atlassian.net/rest/api/2/search?jql=project+in+(TPSVC,CSEL)+AND+issuetype+in+(%22Change+Request%22,+%22Customer+Rule%22,+Defect,+Dictionary,+Project,+%22QA+Testing%22,+Release,+%22Technical+Coding+/+Config%22,+%22QA+Task%22)+AND+created+%3E%3D+2017-04-01+ORDER+BY+created+DESC&startAt=0&maxResults=1000&fields=key,issuetype,status,priority,resolution,created,updated,lastViewed,resolutiondate,components,customfield_11010,customfield_15411,customfield_19611,customfield_10057,customfield_10056,customfield_15210,customfield_14018,customfield_11712");
            ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

            String output = response.getEntity(String.class);

            final ObjectMapper m = new ObjectMapper();

            Issues issues = m.readValue(output, Issues.class);


            for (Issue issue : issues.getIssues()) {
                System.out.println("Issues: " + issue.getFields().getIssueType().getName() + " Status " + issue.getFields().getStatus().getName()
                        + " Priority " + issue.
                        getFields().
                        getPriority().
                        getName() +
                        " Resolution " +
                        issue.getFields().getResolution()
                        + " Created " +
                        issue.getFields().getCreated()

                        + " Updated " +
                        issue.getFields().getUpdated()

                        + " Last viewed " +
                        issue.getFields().getLastViewed()

                        + " Customer " +
                        issue.getFields().getCustomer_s().getValue());


            }



        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}





















//            JsonNode rootNode;
//            try {
//                rootNode = m.readTree(output);
//            } catch (IOException e) {
//                throw new IllegalStateException(e);
//            }
//
//            JsonNode resultNode = rootNode.findPath("issues");
//
//            System.out.println("Json " + resultNode.size());
//
//            for (int i = 0; i < resultNode.size(); i++) {
//                String foundStateValue = resultNode.get(i).findPath("id").asText();
//                System.out.println("id " + foundStateValue);
//            }