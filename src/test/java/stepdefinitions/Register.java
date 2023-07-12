package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import page.repositories.AccountPage;
import page.repositories.HomePage;
import page.repositories.RegisterPage;
import utilities.BrowserUtility;
import utilities.DateUtility;

public class Register 
{

	WebDriver driver;

	@Given("User is navigated to the Regsitration page")
	public void user_is_navigated_to_the_regsitration_page() 
	{
		driver=BrowserUtility.getdriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAcccount();
		homePage.clickOnRegister();
	}

	@When("User enters the details below in the filed")
	public void user_enters_the_details_below_in_the_filed(DataTable dataTable) 
	{
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		RegisterPage register = new RegisterPage(driver);

		register.enterFirstName((dataMap.get("firstname")));
		register.enterLastName((dataMap.get("lastname")));
		register.enterEmail(DateUtility.getEmailStamp());
		register.enterTelephone((dataMap.get("phone")));
		register.enterPassword((dataMap.get("password")));
		register.confirmPassword(dataMap.get("password"));

	}


	@When("User enters the details below in the filed with duplicate email")
	public void user_enters_the_details_below_in_the_filed_with_duplicate_email(DataTable dataTable) 
	{
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		RegisterPage register = new RegisterPage(driver);

		register.enterFirstName((dataMap.get("firstname")));
		register.enterLastName((dataMap.get("lastname")));
		register.enterEmail((dataMap.get("email")));
		register.enterTelephone((dataMap.get("phone")));
		register.enterPassword((dataMap.get("password")));
		register.confirmPassword(dataMap.get("password"));
		
	}

	@When("User should click on Terms and Conditions check-box option")
	public void user_should_click_on_terms_and_conditions_check_box_option() throws InterruptedException 
	{
		RegisterPage registerPage= new RegisterPage(driver);
		registerPage.clickOnTandC();
		Thread.sleep(3000);
		//Assert.fail();
	}

	@When("User should click on Continue button")
	public void user_should_click_on_continue_button() throws InterruptedException 
	{
		RegisterPage registerPage= new RegisterPage(driver);
		registerPage.clickOnContinueBtn();
		Thread.sleep(3000);
	}

	@Then("User should be successfully registered in the account")
	public void user_should_be_successfully_registered_in_the_account() throws InterruptedException 
	{

		AccountPage accountPage=new AccountPage(driver);	
		Assert.assertTrue(accountPage.verifyRegisterSuccessMessage());
	}

	@When("User should select Yes for Newsletter subscription")
	public void user_should_select_yes_for_newsletter_subscription() 
	{
		RegisterPage registerPage= new RegisterPage(driver);
		registerPage.clickOnNewsLetterSub();  
	}

	@When("User do not enters any details")
	public void user_do_not_enters_any_details() 
	{

		RegisterPage registerPage= new RegisterPage(driver);
		registerPage.registerWithNoCredentials();

	}


	@Then("User should be displayed with Warning messages")
	public void user_should_be_displayed_with_warning_messages() throws InterruptedException 
	{
		Thread.sleep(3000);
		RegisterPage registerPage= new RegisterPage(driver);
		
		Assert.assertTrue(registerPage.getWarningMessage());
		Assert.assertTrue(registerPage.FNWarningMessage());
		Assert.assertTrue(registerPage.LNWarningMessage());
		Assert.assertTrue(registerPage.emailWarningMessage() );
		Assert.assertTrue(registerPage.phoneWarningMessage());
		Assert.assertTrue(registerPage.passwordWarningMessage());
	}

	@Then("User should be displayed with warning message saying email is already registered")
	public void user_should_be_displayed_with_warning_message_saying_email_is_already_registered() throws InterruptedException 
	{
		Thread.sleep(3000);
		RegisterPage registerPage= new RegisterPage(driver);
		Assert.assertTrue(registerPage.getWarningMessage());
	}

}
