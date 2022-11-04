package pages2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	 public static void captureScreenShot(WebDriver driver,int testid) throws IOException {
		 SimpleDateFormat date =new SimpleDateFormat("dd.mm.yyyy");
		 Date d =new Date();
		 String dt= date.format(d);
		 
		 TakesScreenshot t =(TakesScreenshot)driver;
		 File src =t.getScreenshotAs(OutputType.FILE);
		 File path =new File("C:\\Users\\SUNIL\\Pictures\\Screenshots"+testid+" "+dt+" .jpeg");
		 FileHandler.copy(src, path);
		
}
	 public static String getdatafromExcelsheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
			String path="C:\\Users\\SUNIL\\Desktop\\selenium.xlsx";
			 FileInputStream file =new FileInputStream(path);
		Sheet s=WorkbookFactory.create(file).getSheet("sheet");
		Row r=s.getRow(row);
		Cell c =r.getCell(cell);
		String data=("");
		 
		 try {
			 data =c.getStringCellValue();
		 }
		 catch(Exception e) {
			  double value =c.getNumericCellValue();
			 data =String.valueOf(value);
			 
			 
		 }
		return data;
	 }}
		 
		
