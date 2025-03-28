package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

//	public static String getXLCellData(String xlpath,String sheetName,int row,int col)
//	{
//		String data="";
//		try 
//		{
//			Workbook wb = WorkbookFactory.create(new FileInputStream(xlpath));
//			Sheet sheet1 = wb.getSheet(sheetName);
//			data = sheet1.getRow(row).getCell(col).toString();
//			wb.close();
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		
//		return data;

	public static String getProperty(String file,String key)
	{
		String value="";
		Properties p=new Properties();
		
		try 
		{
			p.load(new FileInputStream(file));
			value = p.getProperty(key);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return value;
	}
}
