package Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Facebook.CreateNewAccount;
import Facebook.LoginPage;
import Pojo.Browser;
import Utils.Utility;

public class VerifyCreateNewAccount extends Browser
{

	 WebDriver driver;
	 
	 CreateNewAccount  createNewAccount ;
	 
	 LoginPage loginPage ;
	 
	 String testID;
	 
	 static ExtentTest test;
		
	 static ExtentHtmlReporter reporter;
		
	 
	@BeforeTest
	@Parameters("browser")
	
	public void lounchBrowser(String browserName)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		
		ExtentReports extend = new ExtentReports();
		
		extend.attachReporter(reporter);
		
		
			System.out.println("LounchBrowser");
			
			if(browserName.equals("Chrome"))
				
			{
				driver = launchChromeBrowser();
				
			}
				
//			System.setProperty("webdriver.chrome.driver","C:\\Exefile\\chromedriver_win32\\chromedriver.exe");
//	
//			driver = new ChromeDriver();
//			   
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			
//			}
		
			
			if(browserName.equals("Opera"))
				{
					driver = launchOperaBrowser();
					
				}
				
				
//			System.setProperty("webdriver.opera.driver","C:\\Exefile\\operadriver_win64\\operadriver_win64\\operadriver.exe");
//		
//			driver = new OperaDriver();
//			   
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			
//			}
//		

			if(browserName.equals("Edge"))
				
				{
						driver = launchMSEdgeBrowser();
						
				}		
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
//			System.setProperty("webdriver.edge.driver","C:\\Exefile\\edgedriver_win64\\msedgedriver.exe");
//			
//			driver = new EdgeDriver();
//			   
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			
//			}
//			

//			if(browserName.equals("Firefox"))
//				
//			{
//				
//			System.setProperty("webdriver.gecko.driver","C:\\Exefile\\geckodriver-v0.30.0-win64\\geckodriver.exe");
//			
//			driver = new FirefoxDriver();
//			   
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			
//			}
	}
	
	@BeforeClass
	public void createObjectOfPOMClasses()
	{
		loginPage = new LoginPage(driver);
		
		createNewAccount = new  CreateNewAccount(driver);
	}
	
	@BeforeMethod
	public void logintoCreatePage() throws InterruptedException, EncryptedDocumentException, IOException
	{
		   System.out.println("LogintoCreatePage");
		
		   Thread.sleep(2000);
		
		   driver.get("https://www.facebook.com/");
		   
		   Thread.sleep(2000);
		   
           loginPage = new LoginPage(driver);
           
           Thread.sleep(4000);
		   
		   loginPage.clickOncreatNewAccount();
		   
		   createNewAccount = new  CreateNewAccount(driver);
	        
	       Thread.sleep(4000);

	        String Fname = Utility.getDataFromExcel("Sheet1",2, 4);
			
			String Sname = Utility.getDataFromExcel("Sheet1",3, 4);
			
	        String MobNO = Utility.getDataFromExcel("Sheet1",4, 4);
			
	        String Pass = Utility.getDataFromExcel("Sheet1",5, 4);
			
	        
	        createNewAccount.clickOnfirstName(Fname);
	        
	        Thread.sleep(2000);
	        
	        createNewAccount.clickOnsurname(Sname);
        
	        Thread.sleep(2000);
	        
	        createNewAccount.clickOnmobileNo(MobNO);
	        
	        Thread.sleep(2000);
	        
	        createNewAccount.clickOnpassword(Pass);
	        
	        Thread.sleep(2000);
//	        
//	        createNewAccount.DayviaDropDown();
//	        
//	        Thread.sleep(2000);
//	        
//	        createNewAccount.MonthviaDropDown();
//	        
//	        Thread.sleep(2000);
//	        
//	        createNewAccount.YearviaDropDown();
//	        
//	        Thread.sleep(2000);
//	        
//	        createNewAccount.clickOnFemale();
//	        
//	        Thread.sleep(2000);
//	        
//	        createNewAccount.clickOnMale();
//	        
//	        Thread.sleep(2000);
//	        
//	        createNewAccount.clickOnCustom();
//	        
//	        Thread.sleep(2000);
	        
//	        createNewAccount.clickOnpronoun();
//	        
//	        Thread.sleep(2000);
//	        
//	        createNewAccount.clickOnGender();
//	       
//	        Thread.sleep(2000);
	        
//	        createNewAccount.clickOnsignIn();
	        
	}
	
	@Test
	public void verifyfirstName() throws InterruptedException 
	{
		System.out.println("verifyfirstName");
		
		createNewAccount.clickOnfirstName("Fname");
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	
	}
	
	@Test(priority = 2)
	public void verifysurname() throws InterruptedException
	{
		System.out.println("Verifysurname");
		
		createNewAccount.clickOnsurname("Sname");
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	
	}	
	
	@Test (priority = 3)
	public void verifymobileNo() throws InterruptedException
	{
		System.out.println("VerifymobileNo");
		
		createNewAccount.clickOnmobileNo("MobNO");
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	
	}
	
	@Test(priority = 4)
	public void verifypassword() throws InterruptedException
	{
		System.out.println("Verifypassword");
		
		createNewAccount.clickOnpassword("Pass");
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}


	@Test(priority = 5)
	public void verifyDayviaDropDown() throws InterruptedException
	{
		System.out.println("VerifyDayviaDropDown");
		
		createNewAccount.DayviaDropDown();
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}
	
	@Test(priority = 6)
	public void verifyMonthviaDropDown() throws InterruptedException
	{
		System.out.println("VerifyMonthviaDropDown");
		
		createNewAccount.MonthviaDropDown();
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}

	@Test(priority = 7)
	public void verifyYearviaDropDown() throws InterruptedException
	{
		System.out.println("VerifyYearviaDropDown");
		
		createNewAccount.YearviaDropDown();
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}
	
	@Test(priority = 8)
	public void clickOnFemale() throws InterruptedException
	{
		System.out.println("clickOnFemale");
		
		createNewAccount.clickOnFemale();
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}
	

	@Test(priority = 9)
	public void clickOnMale() throws InterruptedException
	{
		System.out.println("clickOnMale");
		
		createNewAccount.clickOnMale();
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}
	
	@Test(priority = 10)
	public void clickOnCustom() throws InterruptedException
	{
		System.out.println("clickOnCustom");
		
		createNewAccount.clickOnCustom();
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}
	
//	@Test(priority = 11)
//	public void clickOnpronoun() throws InterruptedException
//	{
//		System.out.println("clickOnpronoun");
//		
//		Thread.sleep(2000);
//		
//		createNewAccount.clickOnpronoun();
//		
//	}
	
//	@Test(priority = 12)
//	public void clickOnGender() throws InterruptedException
//	{
//		System.out.println("clickOnGender");
//		
//		Thread.sleep(2000);
//		
//		createNewAccount.clickOnGender();
//	
//	}
	
	@Test(priority = 13)
	public void clickOnsignIn() throws InterruptedException
	{
		System.out.println(".clickOnsignIn");
		
		createNewAccount.clickOnsignIn();
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}
	
	@AfterMethod
	public void logOut(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.screenshot(driver, testID);
		}
	
		System.out.println("LogOut");		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("CloseBrowser");
		
		createNewAccount = null;
		
		loginPage = null;
	}
	
	@AfterTest
	public void closedBrowser()
	{
		System.out.println("closedBrowser");
		driver.quit();
		
		driver = null;
		System.gc();                                // Delete the all object without references
		
	}
	
	
}
