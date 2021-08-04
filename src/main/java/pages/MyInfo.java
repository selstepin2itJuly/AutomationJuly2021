package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfo {

	private WebDriver dr;
	public MyInfo(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="[id='menu_pim_viewMyDetails']")
	WebElement myInfoTab;
	
	@FindBy(css="[id='sidebar']>ul>li>a")
	List<WebElement> sideMenu;
	
	public void goToMyInfoTab()
	{
		myInfoTab.click();
	}
	
	public List<String> getSideMenuItems()
	{
		List<String> item=new ArrayList<String>();
		for(WebElement e:sideMenu)
		{
			item.add(e.getText());
		}
		return item;
		
	}
	
	public int getSideMenuItemsCount()
	{
		return sideMenu.size();
	}
}
