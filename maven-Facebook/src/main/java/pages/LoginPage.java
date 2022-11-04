package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		//variables WebElement
	@FindBy (xpath ="//input[@id='email']") 
	private WebElement username;
	
	@FindBy (xpath ="//input[@id='pass']")
	private WebElement pass;
	
	@FindBy(xpath ="//button[text()='Log in'] ")
	private WebElement loginbutton;
	
	@FindBy (xpath="//a[text()='Messenger']")
	private WebElement messengerlink ;
	
	//constructor -initialization
	public LoginPage(WebDriver driver) {
		PageFactory .initElements(driver, this);
	}
	
	//Methods-ACtions on WebElement
	public void senduserName(String user) {
		username.sendKeys(user);
	}
	
	public void sendPassword(String pas) {
		pass.sendKeys(pas);
	}
	public void clickOnLoginButton() {
		loginbutton.click();
		
	}
	public void openMessangerlink() {
		messengerlink.click();
	}
}


