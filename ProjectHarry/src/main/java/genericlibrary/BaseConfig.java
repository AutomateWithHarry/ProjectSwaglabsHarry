package genericlibrary;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import pagerepository.LoginPage;
import pagerepository.LogoutPage;

public class BaseConfig {
	public WebDriver driver;

 @Parameters("BrowserName")
	@BeforeClass
	public void browserSetup(String browser) {
		

		// Open the Browser
		driver = WebDriverLibrary.openBrowser(browser);

		// Maximize the Browser
		WebDriverLibrary.maximizeBrowser();

		// Wait Statement
		WebDriverLibrary.Waitstatement();

		// Navigate to the Application Via URL
		WebDriverLibrary.navToApp(PropertiesLibrary.readData("url"));

		// verify the Page Using Title
		Assert.assertEquals("Swag Labs", driver.getTitle());

	}

	@BeforeMethod
	public void login() {

		// Wait Statement
		WebDriverLibrary.Waitstatement();

		// Create an Object For LoginPage
		LoginPage loginobj = new LoginPage(driver);

		// Validate the UserNameTextField
		Assert.assertTrue(loginobj.getUsernametextfield().isDisplayed());

		// Enter the Username in the UserNameTextField
		WebDriverLibrary.enterTheData(loginobj.getUsernametextfield(), PropertiesLibrary.readData("username"));

		// Validate the PasswordTextField
		Assert.assertTrue(loginobj.getPasswordtextfield().isDisplayed());

		// Enter the Password in the PasswordTextField
		WebDriverLibrary.enterTheData(loginobj.getPasswordtextfield(), PropertiesLibrary.readData("password"));

		// Validate the loginbutton
		Assert.assertTrue(loginobj.getUsernametextfield().isDisplayed());

		// Click on login Button
		WebDriverLibrary.elementClick(loginobj.getLoginbutton());

	}

	@AfterMethod
	public void logout() {
		// Wait Statement
		WebDriverLibrary.Waitstatement();

		// Create An Object for LogoutPage
		LogoutPage logoutobj = new LogoutPage(driver);

		// Validate the logoutMenu
		Assert.assertTrue(logoutobj.getLogoutmenu().isDisplayed());

		// click on logoutMenu
		WebDriverLibrary.elementClick(logoutobj.getLogoutmenu());

		// Validate the Logoutlink
		//Assert.assertTrue(logoutobj.getLogoutlink().isDisplayed());

		// click on logoutlink
		WebDriverLibrary.elementClick_Actions(logoutobj.getLogoutlink());
	}

	@AfterClass
	public void browserTerminate() {
	

		// Close the Browser
		WebDriverLibrary.closeAllWindows();

	}

	@DataProvider
	public Object[][] checkOutInfo() {

		Object[][] data = new Object[1][3];

		data[0][0] = ExcelLibrary.readsingledata("CheckoutDetail", 1, 0);
		data[0][1] = ExcelLibrary.readsingledata("CheckoutDetail", 1, 1);
		data[0][2] = ExcelLibrary.readsingledata("CheckoutDetail", 1, 2);
		

		return data;
	}

}
