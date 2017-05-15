package com.teksystems;

import com.teksystems.datamodel.Root;
import com.teksystems.deserialize.JsonToJava;
import com.teksystems.deserialize.JsonToJavaJacksonImpl;
import com.teksystems.excel.ExcelHelper;
import com.teksystems.excel.ExcelHelperImpl;
import com.teksystems.restclient.JerseyRestClient;
import com.teksystems.restclient.RestClient;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Main class of the application
 */
public class MainClass {
    public static void main(String[] args) {
        RestClient restClient = new JerseyRestClient();
        ExcelHelper excelHelper = new ExcelHelperImpl();
        JsonToJava jsonToJava = new JsonToJavaJacksonImpl();

        String jsonFromJira = restClient.queryJira();

        Root rootObject = jsonToJava.convert(jsonFromJira);

        HSSFWorkbook workbook = excelHelper.createExcelWorkBook(rootObject);

        excelHelper.saveToExcelFile("TEKGraphData.xls", workbook);
    }
}