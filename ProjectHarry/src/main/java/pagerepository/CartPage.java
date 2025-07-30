package pagerepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(id =   "checkout")
	private WebElement checkoutbtn;
	
	@FindBy(className  =   "inventory_item_name")
	private List<WebElement> itemNames;
	
	@FindBy(className  =   "inventory_item_price")
	private List<WebElement> itemPrices;
	
	public WebElement getCheckoutbtn() {
		return checkoutbtn;
	}





	public List<WebElement> getItemNames() {
		return itemNames;
	}





	public List<WebElement> getItemPrices() {
		return itemPrices;
	}





	public List<WebElement> getItemQuantities() {
		return itemQuantities;
	}





	@FindBy(className  =   "cart_quantity")
	private List<WebElement> itemQuantities;
	
	
	
	
	
	public CartPage(WebDriver driver) {
		
		
		PageFactory.initElements(driver, this);
	}

}
