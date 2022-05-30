package KatanaProject.WebAutomation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CreateCustomerPage {
	
	WebDriver driver; 
	public static Logger Log =LogManager.getLogger(base.class.getName());
	
	public CreateCustomerPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By globalPlusSign = By.xpath("//button[@id='globalAdd']");
	private By firstName = By.xpath("//input[@name='firstName']");
	private By lastName = By.xpath("//input[@name='lastName']");
	private By company = By.xpath("//input[@name='company']");
	private By displayName = By.cssSelector("input[name='name']");
	private By email = By.cssSelector("input[name='email']");
	private By phone = By.cssSelector("input[name='phone']");
	private By comment = By.cssSelector("input[name='comment']");
	private By defaultBillingAddress = By.cssSelector("input[name='defaultBillingAddress']");
	private By defaultShippingAddress = By.cssSelector("input[name='defaultShippingAddress']");
	private By globalplusSignList = By.xpath("//div[contains(@class,'MuiPaper-rounded')]/ul/a/div[2]");
	private By changesSaved = By.xpath("//div[contains(@class,'katana-label')]");
	private By BillingAddressElements = By.xpath("//div[contains(@class,'MuiInputBase-root')]/input");
	private By billingSubmitButton = By.xpath("//button[@id='submitButton']");
	private By closebutton = By.xpath("//div[contains(@class,'MuiGrid-grid-xs-12')]/div/div[2]/div/button");
	private By billingAddressSubmitButton = By.xpath("button[id='submitButton']");
	
	public List<WebElement> getGlobalPlusSignList()
	{
		return driver.findElements(globalplusSignList);
	}
	
	public WebElement getplusSign()
	{
		return driver.findElement(globalPlusSign);
	}
	
	public WebElement getFirstName()
	{
		return driver.findElement(firstName);
	}
	
	public WebElement getLastName()
	{
		return driver.findElement(lastName);
	}
	
	public WebElement getCompany()
	{
		return driver.findElement(company);
	}
	
	public WebElement getPhone()
	{
		return driver.findElement(phone);
	}
	
	public WebElement getdisplayName()
	{
		return driver.findElement(displayName);
	}
	
	public WebElement getemailId()
	{
		return driver.findElement(email);
	}
	
	public WebElement getComment()
	{
		return driver.findElement(comment);
	}
	
	public WebElement getBillingAddress()
	{
		return driver.findElement(defaultBillingAddress);
	}
	
	public WebElement getShippingAddress()
	{
		return driver.findElement(defaultShippingAddress);
	}
	
	public WebElement getChangesSaved()
	{
		return driver.findElement(changesSaved);
	}
	
	public List<WebElement> getBillingAddresslist()
	{
		return driver.findElements(BillingAddressElements);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(billingSubmitButton);
	}
	
	public WebElement getCloseButton()
	{
		return driver.findElement(closebutton);
	}
	
	public WebElement getBillingAddressSubmitButton()
	{
		return driver.findElement(billingAddressSubmitButton);
	}
	
	//method to click on global plus sign
	public void ClickGlobalSign()
	{
		getplusSign().click();
		Log.info("Clicked on global plus sign.");
	}
	
	//method to enter first name
	public void EnterFirstName(String firstname)
	{
		getFirstName().sendKeys(firstname);
		Log.info("Entered first name.");
	}
	
	//method to enter first name
		public void EnterLastName(String lastname)
		{
			getLastName().sendKeys(lastname);
			Log.info("Entered last name.");
		}
		
    //method to enter company name
    public void EnterCompanyName(String company)
    {
    	getCompany().sendKeys("Stryker");
    	Log.info("Enter comapany name.");
    }
    
    //method to check display name
    public void CheckDisplayName()
    {
    	String firstname=getFirstName().getAttribute("value");
    	String lastname = getLastName().getAttribute("value");
    	String displayname = getdisplayName().getAttribute("value");
    	Assert.assertEquals(displayname, firstname+" "+lastname);
    }
    
    
    //method to select option from dropdown list of global plus sign
    public void SelectGlobalOption(String opt)
    {
    	List<WebElement> option = getGlobalPlusSignList();
    	for(WebElement a : option)
    	{
    		if(a.getText().equals(opt))
    		{
    			a.click();
    			break;
    		}
    			
    	}
    	Log.info("Selected Global list options.");
    }
    
    //method to enter email id
    public void EnterEmailId(String email)
    {
    	getemailId().sendKeys(email);
    	Log.info("Entered email id.");
    }
    
    //method to enter phone number
    public void EnterPhoneNumber(String number)
    {
    	getPhone().sendKeys(number);
    	Log.info("Entered phone number.");    
    }
    
    //method to enter comment
    public void EnterComment(String comment)
    {
    	getComment().sendKeys(comment);
    	Log.info("Enetered comment.");
    }
    
    //method to check saved changes label
    public void CheckSavedChanges()
    {
    	Assert.assertEquals("All changes saved", getChangesSaved().getText(), "Data entered for adding customer is not saved.");
    }
    
    //method to click on save changes
    public void ClickSaveChanges()
    {
    	getChangesSaved().click();
    	Log.info("Clicked on Not Saved");
    }
    
    //method to click defaultshippingaddress
    public void ClickDefaultShippingAddress()
    {
    	getBillingAddress().click();
    	Log.info("Clicked Default shipping address.");
    }
    
    //method to click elements on billing address screen
    public void SelectAndEnterdataonBillingAddressScreen(String firstname, String lastname, String company, String phone, String Addressline1, String city, String State, String pincode)
    {
    	List<WebElement> element = getBillingAddresslist();
    	for(WebElement a : element)
    	{
    		String x = a.getAttribute("name");
    		/*if(a.getAttribute("name")=="firstName")
    		{
    			a.sendKeys(firstname);
    		}
    		if(a.getAttribute("name")=="lastName")
    		{
    			a.sendKeys(lastname);
    		}
    		if(a.getAttribute("name")=="company")
    		{
    			a.sendKeys(company);
    		}
    		if(a.getAttribute("name")=="phone")
    		{
    			a.sendKeys(phone);
    		}
    		if(a.getAttribute("name")=="line1")
    		{
    			a.sendKeys(Addressline1);
    		}
    		if(a.getAttribute("name")=="city")
    		{
    			a.sendKeys(city);
    		}
    		if(a.getAttribute("name")=="state")
    		{
    			a.sendKeys(State);
    		}
    		if(a.getAttribute("name")=="zip")
    		{
    			a.sendKeys(pincode);
    		}*/
    	}
    	
    	
    }

  //method to click billing submit button
	public void ClickBillingSubmitButton()
	{
		getSubmitButton().click();
		Log.info("Clicked on submit button.");
	}
	
	//method to click close button
	public void ClickCloseButton()
	{
		getCloseButton().click();
		Log.info("Clicked on close button.");
	}
}
