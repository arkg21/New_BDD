package page.repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage 
{

WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement validProductMessage;
	
	@FindBy(xpath="//input[@id='button-search']//following-sibling::p")
	private WebElement invalidProductMessage;
	
	
	public boolean displayValidProduct()
	{
		return validProductMessage.isDisplayed();
	}
	
	public boolean displayInvalidProduct()
	{
		return invalidProductMessage.isDisplayed();
	}
	
}

