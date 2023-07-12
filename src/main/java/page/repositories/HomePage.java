package page.repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountOption;
	
	@FindBy (linkText="Login")
	private WebElement loginOption;
	
	@FindBy (linkText="Register")
	private WebElement regsiterOption;
	
	@FindBy(name="search")
	private WebElement enterValidProduct;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	
	public void clickOnMyAcccount()
	{
		myAccountOption.click();
	}
	
	public void clickOnLogin()
	{
		loginOption.click();
	}
	
	public void clickOnRegister()
	{
		regsiterOption.click();
	}
	
	public void userEntersValidProduct(String validProduct)
	{
		enterValidProduct.sendKeys(validProduct);
	}
	
	public void userEntersInvalidProduct(String invalidProduct)
	{
		enterValidProduct.sendKeys(invalidProduct);
	}

	public void userEntersSearchButton()
	{
		searchButton.click();
	}
	
}
