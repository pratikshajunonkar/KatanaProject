package KatanaProject.WebAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class CreateSales extends base {
	
	public WebDriver driver;
	CreateCustomerPage cc;
	CreateSalesOrderPage cs;
	HomePage hp;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	
	public CreateSales() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
  
  @BeforeTest
  public void beforeTest() throws IOException {
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
  public void CreateSalesOrder() 
  {
	  try
	  {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cc = new CreateCustomerPage(driver);
	    cc.ClickGlobalSign();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cc.SelectGlobalOption("Sales order");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cs = new CreateSalesOrderPage(driver);
		String uniqueCustomer = (String) UUID.randomUUID().toString().subSequence(0, 5);
		cs.EnterCustomer(uniqueCustomer);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cs.selectCustomerOrItem();
		Assert.assertNotEquals(cs.getSalesOrderNo().getText(),"","Sales Order is empty.");
		cs.Clickbillingaddress();
		Assert.assertFalse(cs.CheckOKButton());
		cs.EnterBillingAddressDetails(prop.getProperty("billingfname"), prop.getProperty("billinglname"), prop.getProperty("billingcompany"), prop.getProperty("billingphone"), prop.getProperty("billingaddressline1"),"",prop.getProperty("city"), prop.getProperty("state"), prop.getProperty("country"), prop.getProperty("pincode"));
		cs.ClickOKButton();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String uniqueItem = (String) UUID.randomUUID().toString().subSequence(0, 5);
		cs.Enteritem(uniqueItem);
		cs.selectCustomerOrItem();
		//cs.EnterSalesQuantity("1");
		cs.ClickAndCheckChangesSaved();
		cs.ClickCloseButton();
	  }
	  catch(Exception e)
	  {
		  Assert.fail(e.getMessage());
	  }
  }
  
  @Test
  public void EditCustomerAddress()
  {
	  try
	  {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cc = new CreateCustomerPage(driver);
	    cc.ClickGlobalSign();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cc.SelectGlobalOption("Sales order");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cs = new CreateSalesOrderPage(driver);
		String uniqueCustomer = (String) UUID.randomUUID().toString().subSequence(0, 5);
		cs.EnterCustomer(uniqueCustomer);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cs.selectCustomerOrItem();
		Assert.assertNotEquals(cs.getSalesOrderNo().getText(),"","Sales Order is empty.");
		cs.ClickAndCheckChangesSaved();
		cs.ClickCloseButton();
	    hp=new HomePage(driver);
	    hp.EnterCustomer(uniqueCustomer);
	    Assert.assertTrue(hp.CheckCustomer(uniqueCustomer));
	  }
	  catch(Exception e)
	  {
		  Assert.fail(e.getMessage());
	  }
  }
  
  @Test
  public void EditingAddressOnSalesOrder()
  {
	try
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cc = new CreateCustomerPage(driver);
	    cc.ClickGlobalSign();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cc.SelectGlobalOption("Sales order");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		cs = new CreateSalesOrderPage(driver);
		String uniqueCustomer = (String) UUID.randomUUID().toString().subSequence(0, 5);
		cs.EnterCustomer(uniqueCustomer);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cs.selectCustomerOrItem();
		Assert.assertNotEquals(cs.getSalesOrderNo().getText(),"","Sales Order is empty.");
		cs.Clickbillingaddress();
		cs.EnterBillingAddressDetails(prop.getProperty("billingfname"), prop.getProperty("billinglname"), prop.getProperty("billingcompany"), prop.getProperty("billingphone"), prop.getProperty("billingaddressline1"),"",prop.getProperty("city"), prop.getProperty("state"), prop.getProperty("country"), prop.getProperty("pincode"));
		cs.ClickOKButton();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cs.ClickAndCheckChangesSaved();
		cs.ClickCloseButton();
	    hp=new HomePage(driver);
	    hp.EnterCustomer(uniqueCustomer);
	    hp.SelectOrder(uniqueCustomer);
	    cs.Clickbillingaddress();
	}
	catch(Exception e)
	{
		Assert.fail(e.getMessage());
	}
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
