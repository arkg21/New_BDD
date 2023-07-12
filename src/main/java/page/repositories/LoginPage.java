package page.repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="input-email")
	private WebElement enterEmail;
	
	@FindBy(id="input-password")
	private WebElement enterPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement clickLoginBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement waringMessage;
	
	
	public void getEmail(String email)
	{
		enterEmail.sendKeys(email);
	}
	
	public void getPassword(String password)
	{
		enterPassword.sendKeys(password);
	}
	
	public void clickOnLogin() throws InterruptedException
	{
		Thread.sleep(3000);
		clickLoginBtn.click();
	}
	
	public void detailsWithNocredentials()
	{
		enterEmail.sendKeys("");
		enterPassword.sendKeys("");
		clickLoginBtn.click();;	
	}
	
	public String WarningMessageWithNoCredentials()
	{
		return waringMessage.getText();	
		
	}
	
}
