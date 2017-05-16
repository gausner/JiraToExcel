package com.teksystems.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Jersey implementation.
 */
public class JerseyRestClient implements RestClient {

    private String username = "";
    private String password = "";

    private static final String BASE_URL = "https://tekcloud.atlassian.net/rest/api/2/search?jql=project+in(TPSVC)" +
            "+AND+issuetype+in+(%22Change+Request%22,+%22Customer+Rule%22,+Defect,+Dictionary,+Project,+%22QA" +
            "+Testing%22,+Release,+%22Technical+Coding+/+Config%22,+%22QA+Task%22)+AND+created+%3E%3D+2017-04-01";

    private static final String FILTER = "+ORDER+BY+created+DESC&startAt=%s&maxResults=1001" +
            "&fields=key,issuetype,status,priority,resolution,created,updated,lastViewed,resolutiondate,resolved," +
            "components,customfield_10303,customfield_10307,customfield_10304,customfield_10308,customfield_10306," +
            "customfield_10305,customfield_10400,customfield_10201";

    public  JerseyRestClient(){
        loadLogin();
    }

    public String queryJira() {
        Client client = getClient();

        WebResource webResource = client.resource(BASE_URL + String.format(FILTER, 0));

        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        return response.getEntity(String.class);
    }

    public int countRecords() {
        Client client = getClient();

        WebResource webResource = client.resource(BASE_URL + "&fields=*none");

        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        String responseAsString = response.getEntity(String.class);

        Pattern pattern = Pattern.compile("\"total\":(.*?),");
        Matcher matcher = pattern.matcher(responseAsString);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new RuntimeException("Unable to get number of records");
        }
    }

    public String queryJira(String startAt) {
        Client client = getClient();

        WebResource webResource = client.resource(BASE_URL + String.format(FILTER, startAt));

        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        return response.getEntity(String.class);
    }

    private Client getClient(){
        Client client = Client.create();
        //client.addFilter(new HTTPBasicAuthFilter("gausner@list.ru", "12345678"));
        client.addFilter(new HTTPBasicAuthFilter(username, password));

        this.loadLogin();
        return client;
    }

    private void loadLogin(){

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.username = prop.getProperty("username");
            this.password = prop.getProperty("password");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
