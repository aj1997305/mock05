package testpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

public class Testclass {
public static void main(String[] args) {
	System.out.println("hi");
	System.setProperty("webdriver.chrome.driver", "C:\\liberaries\\chromedriver_win32\\chromedriver.exe");

	WebDriver driver =new ChromeDriver();
	driver.get("https://www.facebook.com/");
	LoginPage loginPage=new LoginPage(driver);
	loginPage.senduserName();
	loginPage.sendPassword();
	loginPage.clickOnLoginButton();
	
	String url = driver.getCurrentUrl();
	String title = driver.getTitle();
	if (url.equals("https://www.facebook.com/") && title.equals("Facebook"))
	{
		System.out.println("PASSED");
	}
	else {
	
		System.out.println("FAILED");
	}
}
}
