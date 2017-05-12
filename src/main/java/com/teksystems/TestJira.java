package com.teksystems;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import  java.io.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;
/**
 * Created by yshamne on 2017-05-11.
 */
public class TestJira {
    public static void main(String[] args) {
        try {

            Client client = Client.create();
            client.addFilter(new HTTPBasicAuthFilter("gausner@list.ru", "12345678"));

            WebResource webResource = client.resource("https://tekcloud.atlassian.net/rest/api/2/search?jql=project+in+(TPSVC,CSEL)+AND+issuetype+in+(%22Change+Request%22,+%22Customer+Rule%22,+Defect,+Dictionary,+Project,+%22QA+Testing%22,+Release,+%22Technical+Coding+/+Config%22,+%22QA+Task%22)+AND+created+%3E%3D+2017-04-01+ORDER+BY+created+DESC&startAt=0&maxResults=1000&fields=key,issuetype,status,priority,resolution,created,updated,lastViewed,resolutiondate,resolved,components,customfield_11010,customfield_15411,customfield_19611,customfield_10057,customfield_10056,customfield_15210,customfield_14018,customfield_11712");
            ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

            String output = response.getEntity(String.class);

            final ObjectMapper m = new ObjectMapper();

            Issues issues = m.readValue(output, Issues.class);

            String filename = "TEKGraphData.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");

            //add header to excel
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("Issue Type");
            rowhead.createCell(1).setCellValue("Status");
            rowhead.createCell(2).setCellValue("Priority");
            rowhead.createCell(3).setCellValue("Resolution");
            rowhead.createCell(4).setCellValue("Created");
            rowhead.createCell(5).setCellValue("Updated");
            rowhead.createCell(6).setCellValue("Last Viewed");
            rowhead.createCell(7).setCellValue("Resolved");
            rowhead.createCell(8).setCellValue("Component/s");
            rowhead.createCell(9).setCellValue("Custom field (Customer(s))");
            rowhead.createCell(10).setCellValue("Custom field (Default Components)");
            rowhead.createCell(11).setCellValue("Custom field (Defect Type)");
            rowhead.createCell(12).setCellValue("Custom field (Detection Point)");
            rowhead.createCell(13).setCellValue("Custom field (Product / Version)");
            rowhead.createCell(14).setCellValue("Custom field (Release Status)");
            rowhead.createCell(15).setCellValue("Custom field (Injection Point)");
            rowhead.createCell(16).setCellValue("Custom field (Root Cause Analysis)");

            //declare all the fields

            String issueID = "";
            String issueType = "";
            String status ="";
            String priority = "";
            String resolution = "";
            String created = "";
            String updated = "";
            String lastViewed = "";
            String resolved = "";
            String components= "";
            String customers = "";
            String defaultComponents = "";
            String defectType = "";
            String defectionPoint = "";
            String injectionPoint= "";
            String productVersion = "";
            String rootCauseAnalysis = "";

            for (int i=1;i<issues.getIssues().size();i++){

                Issue issue = issues.getIssues().get(i);
                issueID = issue.getId();
                issueType = issue.getFields().getIssueType().getName();
                status =  issue.getFields().getStatus().getName();
                priority =  issue.getFields().getPriority().getName();
                resolution = issue.getFields().getResolution().getName();
                created = issue.getFields().getCreated();
                updated = issue.getFields().getUpdated();
                lastViewed = issue.getFields().getLastViewed();
                resolved =issue.getFields().getResolved();
                components= "";
                customers = "";
                defaultComponents = "";
                defectType = "";
                defectionPoint = "";
                injectionPoint= "";
                productVersion = "";
                rootCauseAnalysis = "";

                HSSFRow row = sheet.createRow((short)i);
                row.createCell(0).setCellValue(issueID);
                row.createCell(1).setCellValue(issueType);
                row.createCell(2).setCellValue(status );
                row.createCell(3).setCellValue(priority);
                row.createCell(4).setCellValue(resolution);
                row.createCell(5).setCellValue(created);
                row.createCell(6).setCellValue(updated);
                row.createCell(7).setCellValue(lastViewed);
                row.createCell(8).setCellValue(resolved);
                row.createCell(9).setCellValue(components);
                row.createCell(10).setCellValue(customers);
                row.createCell(11).setCellValue(defaultComponents);
                row.createCell(12).setCellValue(defectType);
                row.createCell(13).setCellValue(defectionPoint);
                row.createCell(14).setCellValue(injectionPoint);
                row.createCell(15).setCellValue(productVersion);
                row.createCell(16).setCellValue(rootCauseAnalysis);

                FileOutputStream fileOut = new FileOutputStream(filename);
                workbook.write(fileOut);
                fileOut.close();

            }

        } catch(IOException e) {
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