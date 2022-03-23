package Facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccount 
{
	
	@FindBy(xpath=("//input[@name='firstname']"))
	
	private WebElement firstName;
	
	@FindBy(xpath=("(//input[@type='text'])[3]"))
	
	private WebElement surname;
	
	@FindBy(xpath=("(//input[@type='text'])[4]"))
	
	private WebElement mobileNo;
	
	@FindBy(xpath=("(//input[@type='password'])[2]"))
	
	private WebElement password;
	
	@FindBy(xpath=("//select[@aria-label='Day']"))
	
	private WebElement day;
	
	@FindBy(xpath=("//select[@aria-label='Month']"))
	
	private WebElement month;
	
	@FindBy(xpath=("//select[@aria-label='Year']"))
	
	private WebElement year;

	@FindBy(xpath=("//label[text()='Female']"))
	
	private WebElement female;
	
	@FindBy(xpath=("//label[text()='Male']"))
	
	private WebElement male;
	
	@FindBy(xpath=("//label[text()='Custom']"))
	
	private WebElement custom;
	
	@FindBy(xpath=("//select[@aria-label='Select your pronoun']"))
	
	private WebElement pronoun;

	@FindBy(xpath=("(//input[@type='text'])[7]"))

	private WebElement gender;
	
	@FindBy(xpath=("(//button[@type='submit'])[2]"))

	private WebElement signIn;
	
	
	public CreateNewAccount (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnfirstName(String Fname) throws InterruptedException
	{
		firstName.click();
		
		Thread.sleep(2000);
		 
		firstName.sendKeys(Fname);
	}
	
	public void clickOnsurname(String Sname) throws InterruptedException
	{
		surname.click();
		
		Thread.sleep(2000);
		
		surname.sendKeys(Sname);
	}
	
	public void clickOnmobileNo(String MobNO) throws InterruptedException
	{
		mobileNo.click();
		
		Thread.sleep(2000);
		
		mobileNo.sendKeys(MobNO);
	}
	
	public void clickOnpassword(String Pass) throws InterruptedException
	{
		password.click();
		
		Thread.sleep(2000);
		
		password.sendKeys(Pass);
	}
	
	public void DayviaDropDown()
	{
		Select a = new Select(day);
		
		a.selectByIndex(22);
	}
	
	public void MonthviaDropDown()
	{
		Select a = new Select(month);
		
		a.selectByVisibleText("Oct");
	}
	
	public void YearviaDropDown()
	{
		Select a = new Select(year);
		
		a.selectByValue("1992");
	}
	
	public void clickOnFemale()
	{
		female.click();
	}
	
	public void clickOnMale()
	{
		male.click();
	}
	
	public void clickOnCustom()
	{
		custom.click();
	}
	
	public void clickOnpronoun()
	{
		Select a = new Select(pronoun);
		
		a.selectByVisibleText("She: \"Wish her a happy birthday!\"");
	}
	
	public void clickOnGender()
	{
		gender.click();
		
		gender.sendKeys("Female");
	}
	
	public void clickOnsignIn()
	{
		signIn.click();
	}
	
}
