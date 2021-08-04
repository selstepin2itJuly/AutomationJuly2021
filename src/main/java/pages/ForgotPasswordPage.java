package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtility;

public class ForgotPasswordPage {

	private WebDriver dr;
	
	public ForgotPasswordPage(WebDriver d)
	{
		this.dr=d;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//h1[text()='Forgot Your Password?']")
	WebElement forgotPassText;
	
	public boolean isDisplayedForgotPassText()
	{
		boolean b=false;
		TestUtility.waitForElement(forgotPassText);
		try 
		{
			b=forgotPassText.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
}
