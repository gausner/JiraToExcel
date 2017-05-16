package com.teksystems;

import com.teksystems.datamodel.Root;
import com.teksystems.deserialize.JsonToJava;
import com.teksystems.deserialize.JsonToJavaJacksonImpl;
import com.teksystems.excel.ExcelHelper;
import com.teksystems.excel.ExcelHelperImpl;
import com.teksystems.restclient.JerseyRestClient;
import com.teksystems.restclient.RestClient;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class of the application
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Please wait while the information is loaded...");

        RestClient restClient = new JerseyRestClient();
        ExcelHelper excelHelper = new ExcelHelperImpl();
        JsonToJava jsonToJava = new JsonToJavaJacksonImpl();
        List<Root> rootObjects = new ArrayList<Root>();

        int count = restClient.countRecords();
        int limit = 1000;

        int recordsArrayCount = calculateRecordsArraySize(count, limit);

        for (int i = 0; i < recordsArrayCount; i++) {
            String startAt = String.valueOf((i + 1) * limit - limit);
            String jsonFromJira = restClient.queryJira(startAt).replace("\\\"", "\"");
            rootObjects.add(jsonToJava.convert(jsonFromJira));
        }

        HSSFWorkbook workbook = excelHelper.createExcelWorkBook(rootObjects);

        excelHelper.saveToExcelFile("GraphData.xls", workbook);

        System.out.println("The information is successfully loaded");
    }

    private static int calculateRecordsArraySize(int count, int limit) {
        int size;

        if ((count % limit) == 0) {
            size = count / limit;
        } else {
            size = count / limit + 1;
        }
        return size;
    }
}