package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Facebook.CreateNewAccount;
import Facebook.LoginPage;
import Utils.Utility;

public class TestClass 
{
     public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException 
     {
        System.setProperty("webdriver.chrome.driver","C:\\Exefile\\chromedriver_win32\\chromedriver.exe");	
        
        WebDriver  driver = new ChromeDriver();
        
        Thread.sleep(4000);
        
        driver.get("https://www.facebook.com/");
        
        Thread.sleep(3000);
        
        LoginPage loginPage = new LoginPage(driver);
        
        String email = Utility.getDataFromExcel("Sheet1", 0, 4);
        
        String pass = Utility.getDataFromExcel("Sheet1", 1, 4);
        
        loginPage.clickOnemailId(email);
        
        Thread.sleep(4000);
        
        loginPage.clickOnpassword(pass);
        
        Thread.sleep(2000);
        
        loginPage.clickOnlogin();
        
        Thread.sleep(3000);
        
        driver.navigate().back();
        
        loginPage.clickOnforgotPassword();
        
        Thread.sleep(4000);
        
        driver.navigate().back();
        
        Thread.sleep(4000);
        
        loginPage.clickOncreatNewAccount();
        
        Thread.sleep(4000);
        
        CreateNewAccount  createNewAccount = new  CreateNewAccount(driver);
        
        Thread.sleep(4000);
        
        String Fname = Utility.getDataFromExcel("Sheet1", 2, 4);
        
        Thread.sleep(2000);
        
        String Sname = Utility.getDataFromExcel("Sheet1", 3, 4);
        
        Thread.sleep(2000);
        
        String MobNO = Utility.getDataFromExcel("Sheet1", 4, 4);
        
        Thread.sleep(2000);
        
        String Pass = Utility.getDataFromExcel("Sheet1", 5, 4);
        
        Thread.sleep(2000);
        
        createNewAccount.clickOnfirstName(Fname);
        
        Thread.sleep(2000);
        
        createNewAccount.clickOnsurname(Sname);
        
        Thread.sleep(2000);
        
        createNewAccount.clickOnmobileNo(MobNO);
        
        Thread.sleep(2000);
        
        createNewAccount.clickOnpassword(Pass);
        
        Thread.sleep(2000);
        
        createNewAccount.DayviaDropDown();
        
        Thread.sleep(2000);
        
        createNewAccount.MonthviaDropDown();
        
        Thread.sleep(2000);
        
        createNewAccount.YearviaDropDown();
        
        Thread.sleep(2000);
        
        createNewAccount.clickOnFemale();
        
        Thread.sleep(2000);
        
        createNewAccount.clickOnMale();
        
        Thread.sleep(2000);
        
        createNewAccount.clickOnCustom();
        
        Thread.sleep(2000);
        
//        createNewAccount.clickOnpronoun();
//        
//        Thread.sleep(2000);
//        
//        createNewAccount.clickOnGender();
//        
//        Thread.sleep(2000);
        
        createNewAccount.clickOnsignIn();
        
        
	}  
}



