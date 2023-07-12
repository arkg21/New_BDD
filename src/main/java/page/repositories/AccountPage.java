package page.repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage 
{

	WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement verifyLoginSuccess;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement verifyRegisterSuccess;
	
	public boolean verfiyAccountPage() throws InterruptedException
	{
		Thread.sleep(2000);
		return verifyLoginSuccess.isDisplayed();
	}
	
	public boolean verifyRegisterSuccessMessage() throws InterruptedException
	{
		Thread.sleep(2000);
		return verifyRegisterSuccess.isDisplayed();
	}
	
	
}
