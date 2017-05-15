package com.teksystems.excel;

import com.teksystems.datamodel.Root;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Excel helper interface.
 */
public interface ExcelHelper {

    void saveToExcelFile(String fileName, HSSFWorkbook workbook);
    HSSFWorkbook createExcelWorkBook(Root issues);
}
