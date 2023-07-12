package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import page.repositories.AccountPage;
import page.repositories.HomePage;
import page.repositories.LoginPage;
import utilities.BrowserUtility;
import utilities.DateUtility;

public class Login 
{
	WebDriver driver;

	@Given("User is navigated to the login page")
	public void user_is_navigated_to_the_login_page() throws InterruptedException 
	{
		driver=BrowserUtility.getdriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAcccount();
		homepage.clickOnLogin();	    
	}

	@When("^User enters valid email address (.+)$")
	public void user_enters_valid_email_address(String emailaddress) 
	{
		
		LoginPage login=new LoginPage(driver);
		login.getEmail(emailaddress);
	    
	}

	@When("^User enters valid password (.+)$")
	public void user_enters_valid_password(String password) 
	{
	  
		LoginPage login=new LoginPage(driver);
		login.getPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException
	{
		
		LoginPage login=new LoginPage(driver);
		login.clickOnLogin();
	}

	@Then("User should be successfully logged in")
	public void user_should_be_successfully_logged_in() throws InterruptedException 
	{
		AccountPage accountPage=new AccountPage(driver);
		accountPage.verfiyAccountPage();
	}

	@When("User enters invalid email address")
	public void user_enters_invalid_email_address() 
	{
		LoginPage login=new LoginPage(driver);
		login.getEmail(DateUtility.getEmailStamp());
		
	}

	@When("User enters invalid password {string}")
	public void user_enters_invalid_password(String invalidPassword) 
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getPassword(invalidPassword);
	}

	@Then("User should not be able to log in")
	public void user_should_not_be_able_to_log_in() throws InterruptedException 
	{
		LoginPage loginPage=new LoginPage(driver);
		Thread.sleep(2000);
	    Assert.assertTrue(loginPage.WarningMessageWithNoCredentials().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@Then("User should receive warning message")
	public void user_should_receive_warning_message() 
	{
		LoginPage loginPage=new LoginPage(driver);
		Assert.assertTrue(loginPage.WarningMessageWithNoCredentials().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User do not enter any credentials")
	public void user_do_not_enter_any_credentials() 
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.detailsWithNocredentials();
	}
	
	
}
