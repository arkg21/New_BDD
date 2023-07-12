package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility 
{

	static WebDriver driver=null;
	
	public static void browserName(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(browser.equals("firefox"))
		{
		    driver=new FirefoxDriver();
		}
		
		else if(browser.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		
	}
	
	public static WebDriver getdriver()
	{
		return driver;
		
	}
	
	
	
}
