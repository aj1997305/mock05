package testpack;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import pages2.Utility;

public class TestNgclass {
	
		private WebDriver driver;
		private LoginPage loginPage;
	private	SoftAssert soft= new SoftAssert();
	private int testid;

		 @BeforeClass
		public void beforeClass()
		{
			System.out.println("Before class");
			System.setProperty("webdriver.chrome.driver", "C:\\liberaries\\chromedriver_win32\\chromedriver.exe");

			 driver =new ChromeDriver();
		}
		 @BeforeMethod
		 public void beforemethod()
		 {
			 driver.get("https://www.facebook.com/");
				 loginPage=new LoginPage(driver);
			 System.out.println("Before method");
		 }
		 @Test
		 public void test() throws EncryptedDocumentException, IOException {
			 testid=121;
		String	data= Utility.getdatafromExcelsheet("Ajay", 1, 0);
			 
			 loginPage.senduserName(data);
			 String value =Utility.getdatafromExcelsheet("Ajay", 1, 1);
			 loginPage.sendPassword(value);
			 loginPage.clickOnLoginButton();
				String url = driver.getCurrentUrl();
				String title = driver.getTitle();
			//	soft.assertEquals(url, "https://www.facebook.com/");
				if (url.equals("https://www.facebook.com/") && title.equals("Facebook"))
				{
					System.out.println("PASSED");
				}
				else {
				System.out.println("FAILED");
		 }	
				//System.out.println("hiii");
			//soft.fail();
			
			// System.out.println("test");
			// soft.assertAll();
		 }
		 @AfterMethod
		 public void aftermethod () throws IOException {
//				if(ITestResult.FAILURE==result.getStatus())
//				{
//					Utility.captureScreenShot(driver, testid);
//				}
			 System.out.println("aftermethod");
		 }
	@AfterClass
	public void afterclass() {
		driver.close();
//			 soft.assertAll();
		 }

	}



