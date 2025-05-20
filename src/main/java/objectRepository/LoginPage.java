package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { // rule 1


	// rule 2-Declaration
	@FindBy(id = "user-name") private WebElement usernameEdt;
	
	@FindBy(id = "password") private WebElement passwordEdt;
	
	@FindBy(name = "login-button") private WebElement loginBtn;
	
	
	
	//rule 3- Initilization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// rule 4 Utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
		
	}

	public void loginToApp(String uSERNAME, String pASSWORD) {
		// TODO Auto-generated method stub
		
	}

}
