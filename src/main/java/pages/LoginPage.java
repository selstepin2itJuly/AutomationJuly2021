package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtility;

public class LoginPage {

	private WebDriver dr;
	
	public LoginPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	//locator
	
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(className="button")
	WebElement loginButton;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotPass;
	
	@FindBy(css="span[id='spanMessage']")
	WebElement invalid;
	
	private void enterUsername(String user)
	{
		username.clear();
		username.sendKeys(user);
	}
	
	private void enterPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	private void clickOnloginButton()
	{
		loginButton.click();
	}
	
	public void loginToApp(String user, String pass)
	{
		enterUsername(user);
		enterPassword(pass);
		clickOnloginButton();
	}
	
	public void clickOnForgotPassword()
	{
		forgotPass.click();
	}
	
	public boolean isDisplayedInvalid()
	{
		TestUtility.waitForElement(invalid);
		boolean b=false;
		try 
		{
			b=invalid.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
}
