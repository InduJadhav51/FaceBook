package Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	public static String getDataFromExcel(String sheet , int row , int cell) throws EncryptedDocumentException,IOException
	{
			String data = " ";

			String path = "C:\\Users\\INDU\\OneDrive\\Desktop\\Excel.xlsx";
		   
			FileInputStream file = new FileInputStream(path);
			
			Workbook workbook  = WorkbookFactory.create(file);
		
			try
			{
				data = workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			}
			
			catch(IllegalStateException e) 
			
			{
				double value = workbook.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
				
				data =  String.valueOf(value);
				
				//data = str;	
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			
			return data;	
	}
	
		public static void screenshot(WebDriver driver,String testID) throws InterruptedException, IOException 
		
			{	   
				File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				File target = new File("C:\\Users\\INDU\\OneDrive\\Desktop\\ABC\\abc"+ testID+ " "+".jpg");
				
				FileHandler.copy(source, target);
			}
	
		}
