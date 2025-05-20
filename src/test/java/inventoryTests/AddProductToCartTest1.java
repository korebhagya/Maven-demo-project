package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtilities;
import genericUtilities.JavaUtilities;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddProductToCartTest1 {
	
	public static void main(String[] args) throws IOException {
		
		
		// Create object of all utilities
				JavaUtilities jUtil = new JavaUtilities();
				SeleniumUtility sUtil = new SeleniumUtility();
				FileUtilities fUtil = new FileUtilities();

				// Read data from property file
				String USERNAME = fUtil.readDataFromPropertyFile("username");
				String PASSWORD = fUtil.readDataFromPropertyFile("password");
				String URL = fUtil.readDataFromPropertyFile("url");

				// Read data from excel File
				String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2);// has to be added to cart-run time datat

				// Launch the browser
				WebDriver driver = new ChromeDriver();
				sUtil.maximizeWindow(driver);
				sUtil.addImplicitlyWait(driver);

				// Load the URL
				driver.get(URL);
				
				//Login to Application
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				//click on product
				InventoryPage ip = new InventoryPage(driver);
				ip.clickOnAProduct(driver, PRODUCTNAME);
				
				//Add Product to cart
				InventoryItemPage iip = new InventoryItemPage(driver);
				iip.clickOnAddTocartBtn();
				
				//Click on cart container
				ip.clickOnCartContainer();
				
				//Validate in cart
				CartPage cp = new CartPage(driver);
				String productInCart = cp.getItemName();
				if(productInCart.equals(PRODUCTNAME))
				{
					System.out.println("pass");
					System.out.println(productInCart);
				}
				else
				{
					System.out.println("fail");
				}
				
				//Logout of App
				ip.logoutOfApp();	
				
				
				
			}

		
	}


