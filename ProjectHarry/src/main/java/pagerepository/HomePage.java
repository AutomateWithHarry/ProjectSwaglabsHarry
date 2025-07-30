package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bike Light')]")
	private WebElement secondprd;

	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Fleece Jacket')]")
	private WebElement thirdprd;

	@FindBy(xpath = "//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")
	private WebElement fourthprd;

	@FindBy(className = "shopping_cart_link")
	private WebElement carticon;

	@FindBy(xpath = "//span[text()='1']")
	private WebElement carticon1;

	@FindBy(xpath = "//span[text()='2']")
	private WebElement carticon2;

	public WebElement getCarticon() {
		return carticon;
	}

	public WebElement getCarticon1() {
		return carticon1;
	}

	public WebElement getCarticon2() {
		return carticon2;
	}

	public WebElement getCarticon3() {
		return carticon3;
	}

	@FindBy(xpath = "//span[text()='3']")
	private WebElement carticon3;

	public WebElement getSecondprd() {
		return secondprd;
	}

	public WebElement getThirdprd() {
		return thirdprd;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getfourthproduct() {
		return fourthprd;
	}

}
