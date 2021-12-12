package Helpers;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ReadingExcel {
    public  String       FileName =PropertyManager.getInstance().getFilePathTestData();
    public  String       Dir            = System.getProperty("user.dir");
    private     XSSFWorkbook Excel;
    private  XSSFSheet Sheet;
    public       int          Number_Row;
    public        int         Number_Column;

    public String[][] ReadingExcel() throws IOException, InvalidFormatException {
        File file = new File(Dir+FileName);
        Excel = new XSSFWorkbook(file);
        Sheet = Excel.getSheet("InvaildTestData");
        Number_Row= (Sheet.getLastRowNum()+1);
        Number_Column = 1;
        String[][] Array= new String[Number_Row-1][Number_Column];

        for(int i =1 ;i<Number_Row;i++)
        {
            for(int y=0 ;y<Number_Column;y++) {
                XSSFRow row = Sheet.getRow(i);
                Array[i-1][y]=row.getCell(y).toString();
            }

        }
        return Array;
    }
}
