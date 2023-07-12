package hooks;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.internal.PropertyUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BrowserUtility;
import utilities.PropertyUtility;

public class MyHooks 
{

	WebDriver driver;
	
	@Before
	public void setUp()
	{
		Properties prop= PropertyUtility.getPropertyData();
		
		BrowserUtility.browserName(prop.getProperty("browser"));
		
		driver=BrowserUtility.getdriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void tearDown(Scenario scenario )
	{
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed())
		{
			byte[] srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenShot, "image/png", scenarioName);
		}
		
		driver.close();
	}
}
