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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Facebook.LoginPage;
import Pojo.Browser;
import Utils.Utility;

public class VerifyLoginPage  extends Browser

{
		WebDriver driver;
		 
		WebDriver wait ;

		LoginPage loginPage;
		
		SoftAssert soft;
		
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
				
//				System.setProperty("webdriver.chrome.driver","C:\\Exefile\\chromedriver_win32\\chromedriver.exe");
//		
//				driver = new ChromeDriver();
//				   
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				
//				}
//			
				
				if(browserName.equals("Opera"))	
				
				{
					
					driver = launchOperaBrowser();
				}
					
//				System.setProperty("webdriver.opera.driver","C:\\Exefile\\operadriver_win64\\operadriver_win64\\operadriver.exe");
//			
//				driver = new OperaDriver();
//				   
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				
//				}
			

				if(browserName.equals("Edge"))
					
				{
					driver = launchMSEdgeBrowser();
					
				}
					
//				System.setProperty("webdriver.edge.driver","C:\\Exefile\\edgedriver_win64\\msedgedriver.exe");
//				
//				driver = new EdgeDriver();
//				   
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				
//				}
				

//				if(browserName.equals("Firefox"))
//					
//				{
//					
//				System.setProperty("webdriver.gecko.driver","C:\\Exefile\\geckodriver-v0.30.0-win64\\geckodriver.exe");
//				
//				driver = new FirefoxDriver();
//				   
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				
//				}
		}
	
		@BeforeClass
	
		public void createObjectOfPOMClasses()
		{
			loginPage = new LoginPage(driver);
		}

		@BeforeMethod
		public void loginToApplication() throws InterruptedException, EncryptedDocumentException, IOException
		{
		System.out.println("loginToApplication");
		
		driver.get("https://www.facebook.com/");
		
		String email = Utility.getDataFromExcel("Sheet1",0, 4);
		
		String pass = Utility.getDataFromExcel("Sheet1",1, 4);
		
		loginPage.clickOnemailId(email);
		
		loginPage.clickOnpassword(pass);

		Thread.sleep(2000);
		loginPage.clickOnlogin();

		Thread.sleep(2000);
		driver.navigate().back();

		Thread.sleep(2000);
		loginPage.clickOnforgotPassword();

		Thread.sleep(5000);
		driver.navigate().back();
		
		Thread.sleep(2000);
		loginPage.clickOncreatNewAccount();
		
		}
		
		@Test
		public void verifyLoginPage()
		{
			testID = "1101";
			
			soft = new SoftAssert();
			
		System.out.println("verifyLoginPage");

		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);

		soft.assertEquals(url,"https://ww.facebook.com/");
		
		soft.assertEquals(title,"Faceboo – log in or sign up");
		
		soft.assertAll();
		
//		if (url.equals("https://www.facebook.com/"))
//		{
//		System.out.println("Pass");
//		}
//		else
//		{
//		System.out.println("Fail");
//		}
//
//		if (title.equals("Facebook – log in or sign up"))
//		{
//		System.out.println("Pass");
//		}
//		else
//		{
//		System.out.println("Fail");
//		}
		}

		@Test(priority = 1)
		public void verifyEmailId()
		{
			testID ="1102";
			
			soft = new SoftAssert();
			
		System.out.println("verifyEmailId");
		
		loginPage.clickOnemailId("email");
	
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		soft.assertEquals(url,"https://www.facebook.com/");
		
		soft.assertEquals(title,"Facebook – log in or sign up");
		
		soft.assertAll();
		
		}
		
		@Test(enabled = false)
		public void verifyPassword()
		{
			testID = "1103";
			
			soft = new SoftAssert();
			
		System.out.println(" verifypassword");
		
		loginPage.clickOnpassword("Pass");
	
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
        soft.assertEquals(url,"https://w.facebook.com/");
		
		soft.assertEquals(title,"https://w.facebook.com/");
		
		soft.assertAll();
		
		}
		
		@Test(priority = 3)
		public void verifyLogIn()
		{
			testID = "1104";
			
			soft = new SoftAssert();
			
		System.out.println(" verifyLogIn");
		
		loginPage.clickOnlogin();
	
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		soft.assertEquals(url,url);
		
		soft.assertEquals(title,title);
		
		soft.assertAll();
	
		}
		
		@Test(priority = 4)
		public void verifyforgotPassword()
		{
			testID = "1105";
			
			soft = new SoftAssert();
			
			
		System.out.println("verifyforgotpassword");
		
		loginPage.clickOnforgotPassword();
	
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		soft.assertEquals(url,url);
		
		soft.assertEquals(title,title);
		
		soft.assertAll();
		
		} 
		
		@Test(priority = 5)
		public void createNewACCount()
		{
			testID = "1106";
			
			soft = new SoftAssert();
			
			
		System.out.println("createNewACCount");
		
		loginPage.clickOncreatNewAccount();
	
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
	
		soft.assertEquals(url,url);
		
		soft.assertEquals(title,title);
		
		soft.assertAll();	
		}
		
		@AfterMethod
		public void logOut(ITestResult result) throws InterruptedException, IOException
		{
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utility.screenshot(driver, testID);
			}
		
			System.out.println("logOut");	
		}

		@AfterClass
		public void closeBrowser()
		{
			System.out.println("CloseBrowser");
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

