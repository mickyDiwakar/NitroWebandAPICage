package com.test.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil extends Thread{
    public ExcelUtil() throws FileNotFoundException {
    }

    public static String readExcelData(String filename) throws IOException {
        FileInputStream fis=new FileInputStream("src/test/resources/TestData/"+filename+".xlsx");
        System.out.println(filename);
        Workbook workbook=new XSSFWorkbook(fis);
        String s=workbook.getSheet("feature").getRow(1).getCell(1  ).getStringCellValue();
        return s;

    }

}
