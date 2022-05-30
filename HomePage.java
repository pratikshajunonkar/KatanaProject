package KatanaProject.WebAutomation;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	private By SignIn = By.xpath("//span[text()='Sign in']");
	private By email = By.xpath("//input[@id='1-email']");
	private By password = By.xpath("//input[@name='password']");
	private By submit = By.xpath("//button[@name='submit']");
	private By customerfilter = By.xpath("//input[@data-testid='customerNameFilterInput']");
	private By customerlist=By.xpath("//div[@class='ag-center-cols-container']/div[1]/div[4]/div/a");
	private By orderlist = By.xpath("//div[@class='ag-center-cols-container']/div[1]/div[3]/div/a");
	
	public List<WebElement> getorderlist()
	{
		return driver.findElements(orderlist);
	}
	
	public List<WebElement> getcustomerlist()
	{
		return driver.findElements(customerlist);
	}
	
	public WebElement getcustomerfilter()
	{
		return driver.findElement(customerfilter);
	}
	
	public WebElement getSignInBtn()
	{
		return driver.findElement(SignIn);
	}
	
	public WebElement getemail()
	{
		return driver.findElement(email);
    }
    
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getSubmitBtn()
	{
		return driver.findElement(submit);
	}
	
	//method to enter email id
	public void EnterEmailId(String email)
	{
		getemail().sendKeys(email);
		Log.info("Entered email id.");
	}
	
	//method to enter password
	public void EnterPassword(String password)
	{
		getpassword().sendKeys(password);
		Log.info("Entered password.");
	}
	
	//method to click on submit button
	public void ClickSubmitBtn()
	{
		getSubmitBtn().click();
		Log.info("Clicked on Submit button.");
	}
	
	//method to input customer name in search filter option
	public void EnterCustomer(String customer)
	{
		getcustomerfilter().sendKeys(customer);
		Log.info("Entered customer in customer filter option.");
	}
	
	//method to check customer exist
	public Boolean CheckCustomer(String Customer)
	{
		Boolean flag=false;
		List<WebElement> customers = getcustomerlist();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for(WebElement x : customers)
		{
			String cc = x.getText();
			if(cc==Customer)
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		}
		return flag;
	}
	
	//method to select order
	public void SelectOrder(String customer)
	{
		List<WebElement> orders = getorderlist();
		for(WebElement x: orders)
		{
			WebElement cus = driver.findElement(By.xpath("//div[@class='ag-center-cols-container']/div[1]/div[3]/following-sibling::div[1]"));
			String c= cus.getText();
			if(c.equals(customer))
			{
				x.click();
			}
		}
	}
}
