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
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class DashboardMyInfo {
	
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private MyInfo ip;
	
  @Test(priority=2, enabled=true,dependsOnMethods="Get_Dashboard_QuickLaunchitemsCounts_007",description="Quick Launch Items verification", groups= {"Regression"})
  public void Get_Dashboard_QuickLaunchitems_004() throws IOException 
  {
	  List<String> expected= new ArrayList<String>();
	  expected.add("Assign Leave");
	  expected.add("Leave Lists");
	  expected.add("Timesheets");
	  expected.add("Apply Leave");
	  expected.add("My Leave");
	  expected.add("My Timesheet");
	  
	  boolean b=dp.isDisplayWelcome();
	  TestUtility.attachScreenshot();
	  Assert.assertTrue(b);
	  List<String> actual = dp.getQuickLaunchItems();
	  TestUtility.attachScreenshot();
	  for(String s:actual)
	  {
		  Reporter.log("Actual:"+s);
	  }
	  Assert.assertEquals(actual, expected);
  }
  
  @Test(priority=1,enabled=true,description="Quick Launch Items Count verification", groups= {"sanity","Regression"})
  public void Get_Dashboard_QuickLaunchitemsCounts_007() throws IOException 
  {
	  boolean b=dp.isDisplayWelcome();
	  Assert.assertTrue(b);
	  TestUtility.attachScreenshot();
	  dp.goToDashboard();
	  int actual = dp.getQuickLaunchItemsCount();
	  TestUtility.attachScreenshot();
	  Reporter.log("Expected: 6 - Actual:"+actual);
	  Assert.assertEquals(actual, 6);
	  Assert.assertTrue(false);
  }
  
  @Test(priority=3, timeOut=4000,description="Legend Items Count verification", groups= {"sanity"})
  public void Get_Dashboard_LegendsitemsCounts_008() throws IOException, InterruptedException 
  {
	  boolean b=dp.isDisplayWelcome();
	  TestUtility.attachScreenshot();
	  Assert.assertTrue(b);
	  dp.goToDashboard();
	  Thread.sleep(3000);
	  int actual = dp.getLegendsItemsCount();
	  TestUtility.attachScreenshot();
	  Reporter.log("Expected: 7 - Actual:"+actual);
	  Assert.assertEquals(actual, 7);
  }
  @Test(priority=5, description="Legend Items verification", groups= {"sanity","Regression"})
  public void Get_Dashboard_Legendsitems_006() throws IOException, InterruptedException 
  {
	  List<String> expected= new ArrayList<String>();
	  expected.add("Not assigned to Subunits");
	  expected.add("Administration");
	  expected.add("Client Services");
	  expected.add("Engineering");
	  expected.add("Finance");
	  expected.add("Human Resources");
	  expected.add("Sales & Marketing");
	  boolean b=dp.isDisplayWelcome();
	  TestUtility.attachScreenshot();
	  Assert.assertTrue(b);
	  dp.goToDashboard();
	  Thread.sleep(3000);
	  List<String> actual = dp.getLegendsItems();
	  TestUtility.attachScreenshot();
	  for(String s:actual)
	  {
		  Reporter.log(s);
	  }
	  Assert.assertEquals(actual, expected);
  }
  
  @Test(priority=4, description="My Info Menu Items verification", groups= {"Regression"})
  public void GetMyInfoSideMenuitems_005() throws IOException 
  {
	  List<String> exp=new ArrayList<String>();
	  exp.add("Personal Details");
	  exp.add("Contact Details");
	  exp.add("Emergency Contacts");
	  exp.add("Dependents");
	  exp.add("Immigration");
	  exp.add("Job");
	  exp.add("Salary");
	  exp.add("Tax Exemptions");
	  exp.add("Report-to");
	  exp.add("Qualifications");
	  exp.add("Memberships");
	  boolean b=dp.isDisplayWelcome();
	  TestUtility.attachScreenshot();
	  Assert.assertTrue(b);
	  ip.goToMyInfoTab();
	  List<String> sItems = ip.getSideMenuItems();
	  TestUtility.attachScreenshot();
	  for(String s:sItems)
	  {
		  Reporter.log(s);
	  }
	  Assert.assertEquals(sItems, exp);
  }
  
  @Test(priority=6, description="My Info Items Count verification", groups= {"Regression"})
  public void Get_MyInfo_SideMenuItemsCounts_009() throws IOException 
  {
	  boolean b=dp.isDisplayWelcome();
	  TestUtility.attachScreenshot();
	  Assert.assertTrue(b);
	  ip.goToMyInfoTab();
	  int actual = ip.getSideMenuItemsCount();
	  TestUtility.attachScreenshot();
	  Reporter.log("Expected: 11 - Actual"+actual);
	  Assert.assertEquals(actual, 11);
  }

  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException 
  {
	  dr=TestBase.getInstance();
	  lp=new LoginPage(dr);
	  dp=new DashboardPage(dr);
	  ip=new MyInfo(dr);
	  lp.loginToApp(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() 
  {
	  dr.quit();
  }

}
