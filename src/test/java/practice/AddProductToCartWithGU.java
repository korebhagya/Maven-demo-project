package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtilities;
import genericUtilities.JavaUtilities;
import genericUtilities.SeleniumUtility;

public class AddProductToCartWithGU {

	public static void main(String[] args) throws IOException {
		// Create Object of Utilities
		FileUtilities fUtil = new FileUtilities();
		JavaUtilities jUtil = new JavaUtilities();
		SeleniumUtility sUtil = new SeleniumUtility();

		// Read data from property file
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		String URL = fUtil.readDataFromPropertyFile("url");

		// Read data from excel File
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2); // Product to be added

		// Launch the browser
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		// Load the URL
		driver.get(URL);

		// Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

		// Click on product - use the excel data - Dynamic xpath
		WebElement ele = driver.findElement(By.xpath("//div[text()='" + PRODUCTNAME + "']"));
		String productTobeAdded = ele.getText();
		ele.click();

		// Capture screenshot
		String screenshotName = "addProductTocart_" + jUtil.getSystemDate();
		String path = sUtil.captureScreenShot(driver, screenshotName);
		System.out.println("Screenshot saved at: " + path);

		// Add product To Cart
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click(); // You may need to update this ID dynamically

		// Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();

		// Validate for the product
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productInCart.equals(productTobeAdded)) {
			System.out.println("PASS - Product added to cart successfully.");
			System.out.println("Product in cart: " + productInCart);
		} else {
			System.out.println("FAIL - Product not found in cart.");
		}

		// Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		//sUtil.waitForElementToBeClickable(driver, By.linkText("Logout")); // optional
		driver.findElement(By.linkText("Logout")).click();

		System.out.println("Logout completed");

		// Close the browser
		driver.quit();
	}
}
