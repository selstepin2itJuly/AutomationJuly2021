package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfo;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class ParamTest {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private MyInfo ip;
  @Parameters({"user","pass"})
  @Test(groups="Regression")
  public void paramTestFromTestNG(String username, String password) throws IOException, InterruptedException
  {
	 
	  lp.loginToApp(username, password);
	  TestUtility.attachScreenshot();
	  dp.logout();
	  TestUtility.attachScreenshot();
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  dr=TestBase.getInstance();
	  lp=new LoginPage(dr);
	  dp=new DashboardPage(dr);
	  ip=new MyInfo(dr);
  }

  @AfterMethod
  public void afterMethod() {
	  dr.quit();
  }

}
