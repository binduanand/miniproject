package com.project.datavisualizationproject;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<ItemData> readExcelData(String filePath) throws IOException {
        List<ItemData> itemList = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        for (Row row : sheet) {
            // Skip the header row (assuming the first row is a header)
            if (row.getRowNum() == 0) continue;

            // Assuming the first column is itemName and second column is itemValue
            String itemName = row.getCell(0).getStringCellValue();
            double itemValue = row.getCell(1).getNumericCellValue();

            itemList.add(new ItemData(itemName, itemValue));
        }

        workbook.close();
        fileInputStream.close();
        return itemList;
    }
}
