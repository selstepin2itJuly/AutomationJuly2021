package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtility;

public class DashboardPage {

	private WebDriver dr;
	public DashboardPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="welcome")
	WebElement welcome;
	
	@FindBy(xpath="//div[@id='welcome-menu']/ul/li/a[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath="//table[@class='quickLaungeContainer']/descendant::span")
	List<WebElement> quickLaunch;
	
	@FindBy(css="td[class='legendLabel']")
	List<WebElement> legends;
	
	@FindBy(id="menu_dashboard_index")
	WebElement dash;
	
	public void goToDashboard()
	{
		dash.click();
	}
	public void logout() throws InterruptedException
	{
		welcome.click();
		TestUtility.waitForElementClickable(logout);
		logout.click();
	}
	
	public List<String> getQuickLaunchItems()
	{
		TestUtility.waitForElement(quickLaunch.get(0));
		List<String> item=new ArrayList<String>();
		for(WebElement e:quickLaunch)
		{
			item.add(e.getText());
		}
		return item;
		
	}
	
	public int getQuickLaunchItemsCount()
	{
		TestUtility.waitForElement(quickLaunch.get(0));
		return quickLaunch.size();
		
	}
	
	public List<String> getLegendsItems()
	{
		TestUtility.waitForElement(legends.get(0));
		List<String> item=new ArrayList<String>();
		for(WebElement e:legends)
		{
			item.add(e.getText());
		}
		return item;
		
	}
	
	public int getLegendsItemsCount()
	{
		TestUtility.waitForElement(legends.get(0));
		return legends.size();
		
	}
	
	public boolean isDisplayWelcome()
	{
		boolean b=false;
		try
		{
			b=welcome.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
}
