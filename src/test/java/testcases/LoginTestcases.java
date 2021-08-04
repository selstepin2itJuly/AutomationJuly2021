package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTestcases {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private ForgotPasswordPage fpt;
  @Test(priority=2, description="Login Success verification", groups= {"sanity","Regression"})
  public void Login_success_001() throws IOException 
  {
	  lp.loginToApp(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
	  boolean b=dp.isDisplayWelcome();
	  TestUtility.attachScreenshot();
	  Assert.assertTrue(b);
	  
  }
  @Test(priority=3, description="Unsuccessful Login verification", groups= {"Regression"})
  public void Login_unsuccessful_002() throws IOException 
  {
	  lp.loginToApp(TestBase.prop.getProperty("username"), "12345");
	  boolean b=lp.isDisplayedInvalid();
	  TestUtility.attachScreenshot();
	  Assert.assertTrue(b);
  }
  @Test(priority=2, description="Forgot Password verification", groups= {"Regression"})
  public void ForgotPassword_003() throws IOException 
  {
	  lp.clickOnForgotPassword();
	  boolean b=fpt.isDisplayedForgotPassText();
	  TestUtility.attachScreenshot();
	  Assert.assertTrue(b);
  }
  
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException 
  {
	  dr=TestBase.getInstance();
	  lp=new LoginPage(dr);
	  dp=new DashboardPage(dr);
	  fpt=new ForgotPasswordPage(dr);
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() throws IOException 
  {
	  TestUtility.attachScreenshot();
	  dr.quit();
  }

}
