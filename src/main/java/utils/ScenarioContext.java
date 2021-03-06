package utils;

import io.cucumber.java.Scenario;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScenarioContext {
    public WebDriver driver;
    public Scenario scenario;

    public Map<String, String> getPropertyTransfer(){
        return propertyTransfer;
    }
    private Map<String,String> propertyTransfer = new LinkedHashMap<String, String>();

    public void scrollDown(int horizontal, int vertical){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+horizontal+","+vertical+")");
    }

    public String getCellValue(String filePath, int sheetIndex, int rowNum, int cellNum) throws IOException {
        File src = new File(filePath);
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(sheetIndex);
        String productName = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
        wb.close();
        return productName;
    }

    public void setCellValue(String filePath, int sheetIndex, int rowNum, int columnNum, String setValue) throws IOException {
        File src = new File(filePath);
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(sheetIndex);
        sheet.getRow(rowNum).createCell(columnNum).setCellValue(setValue);
        FileOutputStream fout= new FileOutputStream(src);
        wb.write(fout);
        wb.close();
    }
    public void clearCellValue(String filePath, int sheetIndex, int rowNum, int columnNum, String setValue) throws IOException {
        File src = new File(filePath);
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(sheetIndex);
        sheet.getRow(rowNum).createCell(columnNum).setCellValue(setValue);
        FileOutputStream fout= new FileOutputStream(src);
        wb.write(fout);
        wb.close();
    }
}
