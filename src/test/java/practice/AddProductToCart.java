package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCart {

	public static void main(String[] args) {
		// Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Load the URL
		driver.get("https://www.saucedemo.com/");
		
		//Login to Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		// click on product-Bike light
	    WebElement ele=driver.findElement(By.xpath("//div[.='Sauce Labs Bike Light']"));
		String productTobeAdded = ele.getText();
		ele.click();
		// Add product to cart
		
		// Add product to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		// Validate for product
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(productInCart.equals(productTobeAdded))
		{
			System.out.println("PASS");
			System.out.println(productInCart);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Logout Completed");
		

	}

}
