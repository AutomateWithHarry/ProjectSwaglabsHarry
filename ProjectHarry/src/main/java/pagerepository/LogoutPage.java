package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	// Declaration
	@FindBy(css = "#react-burger-menu-btn")
	private WebElement logoutmenu;

	@FindBy(xpath  =   "//a[text()='Logout']")
	private WebElement logoutlink;

	// Utilization
	public WebElement getLogoutmenu() {
		return logoutmenu;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}

	// initilization
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}


}
