package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	@FindBy(id = "first-name")
	private WebElement firstname;

	@FindBy(id = "last-name")
	private WebElement lastname;

	@FindBy(id = "postal-code")
	private WebElement zipcode;

	@FindBy(id = "continue")
	private WebElement continuebtn;

	public CheckoutPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getZipcode() {
		return zipcode;
	}

	public WebElement getContinuebtn() {
		return continuebtn;
	}

}
