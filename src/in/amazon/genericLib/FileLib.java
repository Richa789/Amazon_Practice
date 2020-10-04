package in.amazon.genericLib;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLib {
    public String getPropKeyValue(String propPath, String Key) throws IOException {
        FileInputStream fis = new FileInputStream(propPath);
        Properties prop = new Properties();
        prop.load(fis);
        String propValue = prop.getProperty(Key, "Incorrect Key");
        return propValue;
    }
    public String getCellData(String excelPath, String sheetName, int row, int cell ) throws IOException {
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook wb = WorkbookFactory.create(fis);
        String value = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
        return value;
    }

    public int getRowCount(String excelPath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook wb = WorkbookFactory.create(fis);
        int rowCount = wb.getSheet(sheetName).getLastRowNum();
        return rowCount;
    }

    public void setCellData(String excelPath, String sheetName, int row, int cell, String data) throws IOException {
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook wb = WorkbookFactory.create(fis);
        wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(data);
        FileOutputStream fos = new FileOutputStream(excelPath);
        wb.write(fos);
    }
}

