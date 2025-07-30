package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Declaration
	@FindBy(id = "user-name")
	private WebElement usernametextfield;

	@FindBy(id = "password")
	private WebElement passwordtextfield;

	// initilization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Utilization
	public WebElement getUsernametextfield() {
		return usernametextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	@FindBy(id = "login-button")
	private WebElement loginbutton;

}
