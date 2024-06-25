package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	

public static String getStringData(int a,int b, String sheetname) 
{
	try
	{
	String path=Constants.HOME_DIRECTORY+Constants.TESTDATA_EXCELPATH;
	f=new FileInputStream(path);
	w=new XSSFWorkbook(f);
	sh=w.getSheet(sheetname);
	Row r=sh.getRow(a);
	Cell c=r.getCell(b);
	return c.getStringCellValue();
	}
	catch(Exception e)
	{
		throw new RuntimeException("Excelsheet not found");
	}
	
}


public static String getIntegerData(int a,int b, String sheetname) 
{
	try
	{
	String path=Constants.HOME_DIRECTORY+Constants.TESTDATA_EXCELPATH;
	f=new FileInputStream(path);
	sh=w.getSheet(sheetname);
	Row r=sh.getRow(a);
	Cell c=r.getCell(b);
	int x=(int) c.getNumericCellValue();
	return String.valueOf(x);
	}
	catch(Exception e)
	{
		throw new RuntimeException("excelsheet not found");
	}
	
}

}
