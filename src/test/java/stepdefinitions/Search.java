package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import page.repositories.HomePage;
import page.repositories.SearchPage;
import utilities.BrowserUtility;

public class Search 
{
	WebDriver driver;

	@Given("User opens the application")
	public void user_opens_the_application() 
	{
		driver=BrowserUtility.getdriver();
	}

	@When("User enters valid product {string} in search text field")
	public void user_enters_valid_product_in_search_text_field(String validProduct) 
	
	{
		HomePage homePage=new HomePage(driver);
		homePage.userEntersValidProduct(validProduct);
		//Assert.fail();
	
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() 
	{
		HomePage homePage=new HomePage(driver);
		homePage.userEntersSearchButton();
	}

	@Then("User should be seeing valid product in search results")
	public void user_should_be_seeing_valid_product_in_search_results() 
	{
		SearchPage searchPage=new SearchPage(driver);
	    Assert.assertTrue(searchPage.displayValidProduct());
	}


	@When("User enters invalid product {string} in search text field")
	public void user_enters_invalid_product_in_search_text_field(String invalidProduct) 
	{
		HomePage homePage=new HomePage(driver);
		homePage.userEntersInvalidProduct(invalidProduct);
	  
	}

	@Then("User should be displayed with warning text saying the no product matches")
	public void user_should_be_displayed_with_warning_text_saying_the_no_product_matches() 
	{
		SearchPage searchPage=new SearchPage(driver);
	  Assert.assertTrue(searchPage.displayInvalidProduct());
	}

	@When("User do not enter the product in search text field")
	public void user_do_not_enter_the_product_in_search_text_field() 
	{
		HomePage homePage=new HomePage(driver);
		homePage.userEntersSearchButton();
	}

	
}
