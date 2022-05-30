package KatanaProject.WebAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public base() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		prop.load(fis);
	}
	
	public WebDriver InitializeBrowser(String browserName) throws IOException
	{
		switch(browserName)
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
				ChromeOptions option = new ChromeOptions();
				if(browserName.contains("headless"))
				{
					option.addArguments("headless");
				}		
				driver =new ChromeDriver(option);
			break;		
		}
			
		return driver;
		
	}

}
