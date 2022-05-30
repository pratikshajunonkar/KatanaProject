package KatanaProject.WebAutomation;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CreateCustomer extends base{
	
	public WebDriver driver;
	CreateCustomerPage cc;
	HomePage hp;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	
	public CreateCustomer() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void InitializeApp() throws IOException
	{
		driver=InitializeBrowser(prop.getProperty("browser"));
		Log.info("Driver is initialized.");
		driver.get(prop.getProperty("createCustomerUrl"));
		Log.info("Navigated to Create Customer page.");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		hp=new HomePage(driver);
		hp.EnterEmailId(prop.getProperty("email"));
		hp.EnterPassword(prop.getProperty("password"));
		hp.ClickSubmitBtn();
	}
	
	@Test
	public void CreateCustomer() throws InterruptedException
	{
		try
		{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cc = new CreateCustomerPage(driver);
	    cc.ClickGlobalSign();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		cc.SelectGlobalOption("Customer");
		Assert.assertTrue(cc.getFirstName().isEnabled(), "Create customer page is not displayed.");
		cc.EnterFirstName(prop.getProperty("firstname"));
		cc.EnterLastName(prop.getProperty("lastname"));
		cc.EnterCompanyName(prop.getProperty("company"));
		cc.CheckDisplayName();
		cc.EnterEmailId(prop.getProperty("email"));
		Assert.assertFalse(cc.getemailId().getAttribute("aria-invalid").equals("False"), "Entered email id is incorrect.");
		cc.EnterPhoneNumber(prop.getProperty("phonenumber"));
		cc.EnterComment(prop.getProperty("comment"));
		cc.ClickSaveChanges();
		cc.CheckSavedChanges();
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
    }
	
	@Test
	public void CreateCustomerWithAddress()
	{
		try
		{
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cc = new CreateCustomerPage(driver);
	    cc.ClickGlobalSign();
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		cc.SelectGlobalOption("Customer");
		Assert.assertTrue(cc.getFirstName().isEnabled(), "Create customer page is not displayed.");
		cc.EnterFirstName(prop.getProperty("firstname"));
		cc.EnterLastName(prop.getProperty("lastname"));
		cc.EnterCompanyName(prop.getProperty("company"));
		cc.CheckDisplayName();
		cc.ClickDefaultShippingAddress();
		Assert.assertFalse(cc.getBillingAddressSubmitButton().isEnabled());
		cc.SelectAndEnterdataonBillingAddressScreen(prop.getProperty("billingfname"),prop.getProperty("billinglname"), prop.getProperty("billingcompany"), prop.getProperty("billingphone"), prop.getProperty("billingaddressline1"), prop.getProperty("city"),prop.getProperty("state"), prop.getProperty("pincode"));
		cc.ClickBillingSubmitButton();
		cc.ClickSaveChanges();
		cc.CheckSavedChanges();
		cc.ClickCloseButton();
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}
	
	@AfterTest
	public void AfterTest()
	{
		driver.close();
	}
}
