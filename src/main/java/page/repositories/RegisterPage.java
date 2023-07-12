package page.repositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{

	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstname;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-password")
	private WebElement confirmPassword;	
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebtn;
	
	@FindBy(name="newsletter")
	private WebElement newsletterSubscription;
	
	@FindBy(name="agree")
	private WebElement termsAndCond;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement verifyFN;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement verifyLN;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement verifyEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement verifyPhone;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement verifyPassword;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
    private WebElement warningMessage;
	
	
	public void enterFirstName(String firstName)
	{
		firstname.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		lastname.sendKeys(lastName);
	}
	
	public void enterEmail(String emailAddress)
	{
		email.sendKeys(emailAddress);
	}
	
	public void enterTelephone(String telephoneNumb)
	{
		telephone.sendKeys(telephoneNumb);
	}
	
	public void enterPassword(String entPassword)
	{
		password.sendKeys(entPassword);
	}
	
	
	public void confirmPassword(String confirmPassword)
	{
		password.sendKeys(confirmPassword);
	}
	
	public void clickOnContinueBtn()
	{
		continuebtn.click();
	}
	
	public void clickOnNewsLetterSub()
	{
		newsletterSubscription.click();
	}
	
	public void clickOnTandC()
	{
		termsAndCond.click();
	}
	
	public void registerWithNoCredentials()
	{
		firstname.sendKeys("");
		lastname.sendKeys("");
		email.sendKeys("");
		telephone.sendKeys("");
		password.sendKeys("");
		confirmPassword.sendKeys("");
	}
	
	public boolean FNWarningMessage()
	{
		return verifyFN.isDisplayed();
	}
	
	public boolean LNWarningMessage()
	{
		return verifyLN.isDisplayed();
	}
	
	public boolean emailWarningMessage()
	{
		return verifyEmail.isDisplayed();
	}
	
	public boolean phoneWarningMessage()
	{
		return verifyPhone.isDisplayed();
	}
	
	public boolean passwordWarningMessage()
	{
		return verifyPassword.isDisplayed();
	}
	
	public boolean getWarningMessage()
	{
		return warningMessage.isDisplayed();
	}
	
	
}
