

package twist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import US.util;
public class HalfEbay {
WebDriver driver;
	
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\softwares\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://hawaiianstagingv4.smartkargo.com/");
		
		
	}
	
	@DataProvider
	public Iterator<Object[]> getData() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ArrayList<Object[]> testData = util.getExcelData();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getData")
	public void Login(String username, String password, String station)
	{
		//String username, String password, String station
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(username);
		//driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPwd")).sendKeys(password);
		//driver.findElement(by.id("ctl00_ContentPlaceHolder1_txtStation")).sendKeys(password);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin")).click();
		driver.findElement(By.id(""));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
