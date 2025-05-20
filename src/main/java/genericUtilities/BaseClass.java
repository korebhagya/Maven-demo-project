package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This method 
 */

public class BaseClass {
	public JavaUtilities jUtil = new JavaUtilities();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public FileUtilities fUtil = new FileUtilities();
	
	public WebDriver driver;
	
	// For listener
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("=======Database Connection successful=====");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String pValue*/) throws IOException
	{
		String URL  = fUtil.readDataFromPropertyFile("url");
		
		driver = new ChromeDriver();
		
		// cross browser execution "Run time polymorphism-driver"
		//if(pValue.equals("chrome"))
		//{
		//	driver = new ChromeDriver();
		//}
		//else if(pValue.equals("edge")) 
		//{
		//	driver = new EdgeDriver();
		//}
			//else
			//{
				//driver = new ChromeDriver();
			
			//}
		
				
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		// for Listeners
		sdriver = driver;
		
		System.out.println("=======Browser launch successful=====");
	}
	
	@BeforeMethod(alwaysRun = true)
	
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("=======Login to app successful=====");
	}
	
	@AfterMethod(alwaysRun = true)
	
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("=======Logout to app successful=====");
	}

	//@AfterClass
	@AfterClass(alwaysRun = true)
	
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("=======Browser closure successful=====");
	}
	
	@AfterSuite(alwaysRun = true)
	
	public void asConfig()
	
	{
		System.out.println("=======Database closure successful=====");
	}
}
