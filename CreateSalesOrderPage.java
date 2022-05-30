package KatanaProject.WebAutomation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CreateSalesOrderPage {
	
	WebDriver driver;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	
	public CreateSalesOrderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By CustomerSalesOrder = By.xpath("//input[contains(@class,'MuiInputBase-inputAdornedEnd')]");
	private By salesOrderNo= By.cssSelector("input[name='orderNo']");
	private By salesbillingAddress = By.xpath("//p[@data-testid='address-field-new']");
	private By quantitylist=By.xpath("//div[@role='gridcell']");
	private By savechanges=By.xpath("//div[contains(@class,'katana-label')]");
	private By shiptoaddress = By.xpath("//p[@data-testid='address-field-same']");
	private By unitmeasure = By.xpath("//input[@placeholder='Select or create unit of measure']");
	private By itemname = By.xpath("//div[@data-cy='so-rows']/div/div/div[2]/div/div[3]/div[2]/div/div/div[1]/div[2]");
	private By customerlist=By.xpath("//div[@class='MuiAutocomplete-popper']/div/ul/li");
	private By salesquantity= By.xpath("//div[@class='ag-react-container']/div[1]/input");
	private By salesfirstname = By.xpath("//input[@name='firstName']");
	private By saleslastname = By.xpath("//input[@name='lastName']");
	private By salescompany = By.xpath("//input[@name='company']");
	private By salesphone=By.xpath("//input[@name='phone']");
	private By salesline1 = By.xpath("//input[@name='line1']");
	private By salesline2 = By.xpath("//input[@name='line2']");
	private By salescity = By.xpath("//input[@name='city']");
	private By salesstate = By.xpath("//input[@name='state']");
	private By salespincode = By.xpath("//input[@name='zip']");
	private By salescountry = By.xpath("//input[@name='country']");
	private By changesaved = By.xpath("//div[contains(@class,'katana-label')]");
	private By okbutton = By.xpath("//button[@data-testid='submitButton']");
	private By closebtn = By.xpath("//button[contains(@class,'print-hide')]");
	
	public WebElement getclosebutton()
	{
		return driver.findElement(closebtn);
	}
	
	public WebElement getOkButton()
	{
		return driver.findElement(okbutton);
	}
	
	public WebElement getsalesfirstname()
	{
		return driver.findElement(salesfirstname);
	}
	
	public WebElement getsaleslastname()
	{
		return driver.findElement(saleslastname);
	}
	
	public WebElement getsalescompany()
	{
		return driver.findElement(salescompany);
	}
	
	public WebElement getsalesphone()
	{
		return driver.findElement(salesphone);
	}
	
	public WebElement getsalesline1()
	{
		return driver.findElement(salesline1);
	}
	
	public WebElement getsalesline2()
	{
		return driver.findElement(salesline2);
	}
	
	public WebElement getsalescity()
	{
		return driver.findElement(salescity);
	}
	
	public WebElement getsalesstate()
	{
		return driver.findElement(salesstate);
	}
	
	public WebElement getsaleszip()
	{
		return driver.findElement(salespincode);
	}
	
	public WebElement getsalescountry()
	{
		return driver.findElement(salescountry);
	}
	
	public WebElement getCustomerSalesOrder()
	{
		return driver.findElement(CustomerSalesOrder);
	}
	
	public WebElement getSalesOrderNo()
	{
		return driver.findElement(salesOrderNo);
	}
	
	public WebElement getsalesbillingAddress()
	{
		return driver.findElement(salesbillingAddress);
	}
	
	public List<WebElement> getquantityList() {
		return driver.findElements(quantitylist);
	}
	
	public WebElement getsavechanges()
	{
		return driver.findElement(savechanges);
	}
	
	public WebElement getsgiptoaddress()
	{
		return driver.findElement(shiptoaddress);
	}
	
	public WebElement getunitmeasure()
	{
		return driver.findElement(unitmeasure);
	}
	
	public WebElement getitem()
	{
		return driver.findElement(itemname);
	}
	
	public List<WebElement> getcustomerlist()
	{
		return driver.findElements(customerlist);
	}

	public WebElement getSalesQuantity()
	{
		return driver.findElement(salesquantity);
	}
	
	public WebElement getchangesaved()
	{
		return driver.findElement(changesaved);
	}
	
	//method to click and check saved changes on sales order page
	public void ClickAndCheckChangesSaved()
	{
		getchangesaved().click();
		Assert.assertEquals(getchangesaved().getText(), "All changes saved", "changes are not saved.");
		Log.info("All changes are saved.");
	}
	
	//method to click billing address
	public void Clickbillingaddress()
	{
		getsalesbillingAddress().click();
		Log.info("Clicked on billing address");
	}
	
	//method to select customer from dropdown
	public void EnterCustomer(String name)
	{
		getCustomerSalesOrder().sendKeys(name);
		//getCustomerSalesOrder().sendKeys(Keys.ENTER);
		Log.info("entered new customer.");
	}
	
	public void Enteritem(String item)
	{
		//getitem().click();
		getitem().sendKeys(item);
		//getitem().sendKeys(Keys.ENTER);
		Log.info("entered new item.");
	}
	
	//method to create or select new item in quantity
	public void selectCustomerOrItem()
	{
		List<WebElement> customers = getcustomerlist();
		for(WebElement x : customers)
		{
			String c = x.getText();
			
			if(c.contains("Create new"))
			{
				x.click();
				break;
			}
		}
		Log.info("Selected or created for new item.");
	}
	
	//methid to enter sales quantity
	public void EnterSalesQuantity(String i)
	{
		getSalesQuantity().sendKeys(i);
		Log.info("entered sales quantity.");
	}
	
	//method to enter billing details
	public void EnterBillingAddressDetails(String firstname, String lastname, String company, String phone, String line1, String line2, String city, String state, String country, String pincode)
	{
		try
		{
		getsalesfirstname().sendKeys(firstname);
		Log.info("Entered firstname of billing address.");
		getsaleslastname().sendKeys(lastname);
		Log.info("Entered lastname of billing address.");
		getsalescompany().sendKeys(company);
		Log.info("Entered company of billing address.");
		getsalesphone().sendKeys(phone);
		Log.info("Enetered phone of billing address.");
		getsalesline1().sendKeys(line1);
		Log.info("Entered address line1 of billing address.");
		getsalesline2().sendKeys(line2);
		Log.info("entered address line 2 of billing address.");
		getsalescity().sendKeys(city);
		Log.info("Entered city of billing address.");
		getsalescountry().sendKeys(country);
		Log.info("Entered country of billing address.");
		getsaleszip().sendKeys(pincode);
		Log.info("Entered pincode of billing address.");
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}
	
	//method to check status of OK button
	public Boolean CheckOKButton()
	{
		Boolean flag= false;
		if(getOkButton().isEnabled())
		{
			return flag=true;
		}
		else
			return flag=false;
	}
	
	//method to click on OK button
	public void ClickOKButton()
	{
		getOkButton().click();
		Log.info("Clicked on OK button.");
	}
	
	//method to click on close button
	public void ClickCloseButton()
	{
		getclosebutton().click();
		Log.info("clicked on close button.");
	}
}

