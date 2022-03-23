package Pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser
{
	public static WebDriver launchChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Exefile\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		return driver;
	}
	
	public static WebDriver launchOperaBrowser()
	{
		System.setProperty("webdriver.opera.driver","C:\\Exefile\\operadriver_win64\\operadriver_win64\\operadriver.exe");
		
		WebDriver driver = new OperaDriver();
		
		return driver;
	}
	
	public static WebDriver launchMSEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver","C:\\Exefile\\edgedriver_win64\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		return driver;
	}

}
