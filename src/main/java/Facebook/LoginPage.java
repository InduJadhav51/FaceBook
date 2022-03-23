package Facebook;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{

	@FindBy(xpath="//input[@type='text']")
	
	private WebElement emailId;
	
	@FindBy(xpath="//input[@type='password']")
	
	private WebElement password;
	
	@FindBy(xpath="//button[@value='1']")
	
	private WebElement login;
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	
	private WebElement forgotPassword;
	
	@FindBy(xpath="(//a[@role='button'])[2]")
		
	private WebElement creatNewAccount;
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)           //driver = driver = new chromeDriver()
	{
		PageFactory.initElements(driver,this);
		
		 this.driver = driver;
	}
	
	public void clickOnemailId(String email)
	{
		
		emailId.sendKeys(email);
		
	}
	public void clickOnpassword(String pass)
	{
		
		password.sendKeys(pass);
	}
	
	public void clickOnlogin()
	{
		login.click();
	}
	
	public void clickOnforgotPassword()
	{
		forgotPassword.click();
	}
	
	public void clickOncreatNewAccount()
	{
		creatNewAccount.click();
	}
}
