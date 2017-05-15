package com.teksystems.excel;

import com.teksystems.datamodel.Issue;
import com.teksystems.datamodel.Root;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Excel helper implementation.
 */
public class ExcelHelperImpl implements ExcelHelper {
    public void saveToExcelFile(String fileName, HSSFWorkbook workbook) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create the file: " + fileName);
        }
    }

    public HSSFWorkbook createExcelWorkBook(Root issues) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("FirstSheet");

        //add header to excel
        HSSFRow rowhead = sheet.createRow((short) 0);
        rowhead.createCell(0).setCellValue("Issue");
        rowhead.createCell(1).setCellValue("Issue Type");
        rowhead.createCell(2).setCellValue("Status");
        rowhead.createCell(3).setCellValue("Priority");
        rowhead.createCell(4).setCellValue("Resolution");
        rowhead.createCell(5).setCellValue("Created");
        rowhead.createCell(6).setCellValue("Updated");
        rowhead.createCell(7).setCellValue("Last Viewed");
        rowhead.createCell(8).setCellValue("Resolution Date");
        rowhead.createCell(9).setCellValue("Resolved");
        rowhead.createCell(10).setCellValue("Component/s");
        rowhead.createCell(11).setCellValue("Custom field (Customer(s))");
        rowhead.createCell(12).setCellValue("Custom field (Default Component)");
        rowhead.createCell(13).setCellValue("Custom field (Defect Type)");
        rowhead.createCell(14).setCellValue("Custom field (Detection Point)");
        rowhead.createCell(15).setCellValue("Custom field (Injection Point)");
        rowhead.createCell(16).setCellValue("Custom field (Product / Version)");
        rowhead.createCell(17).setCellValue("Custom field (Release Status)");
        rowhead.createCell(18).setCellValue("Custom field (Root Cause Analysis)");

        for (int i = 1; i < issues.getIssues().size(); i++) {
            Issue issue = issues.getIssues().get(i);

            String issueID = issue.getId();
            String issueType = issue.getFields().getIssueType().getName();
            String status = issue.getFields().getStatus().getName();
            String priority = issue.getFields().getPriority().getName();
            String resolution = issue.getFields().getResolution().getName();
            String created = issue.getFields().getCreated();
            String updated = issue.getFields().getUpdated();
            String lastViewed = issue.getFields().getLastViewed();
            String resolutionDate = issue.getFields().getResolution().getName();
            String resolved = issue.getFields().getResolved();
            String components = issue.getFields().getComponent().getValue();
            String customers = issue.getFields().getCustomer_s().getValue();
            String defaultComponents = issue.getFields().getDefaultComponents().getValue();
            String defectType = issue.getFields().getDefectType().getValue();
            String defectionPoint = issue.getFields().getDetectionPoint().getValue();
            String releaseStatus = issue.getFields().getReleaseStatus().getValue();
            String injectionPoint = issue.getFields().getInjectionPoint().getValue();
            String productVersion = issue.getFields().getProductVersion().getValue();
            String rootCauseAnalysis = issue.getFields().getRootCauseAnalysis().getValue();

            HSSFRow row = sheet.createRow((short) i);
            row.createCell(0).setCellValue(issueID);
            row.createCell(1).setCellValue(issueType);
            row.createCell(2).setCellValue(status);
            row.createCell(3).setCellValue(priority);
            row.createCell(4).setCellValue(resolution);
            row.createCell(5).setCellValue(created);
            row.createCell(6).setCellValue(updated);
            row.createCell(7).setCellValue(lastViewed);
            row.createCell(8).setCellValue(resolutionDate);
            row.createCell(9).setCellValue(resolved);
            row.createCell(10).setCellValue(components);
            row.createCell(11).setCellValue(customers);
            row.createCell(12).setCellValue(defaultComponents);
            row.createCell(13).setCellValue(defectType);
            row.createCell(14).setCellValue(defectionPoint);
            row.createCell(15).setCellValue(injectionPoint);
            row.createCell(16).setCellValue(productVersion);
            row.createCell(17).setCellValue(releaseStatus);
            row.createCell(18).setCellValue(rootCauseAnalysis);

        }
        return workbook;
    }
}
