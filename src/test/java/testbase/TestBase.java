package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	public static WebDriver dr;
	public static Properties prop;
	public static String browser;
	private static String conf="./src/main/java/config/config.properties";
	
	public static WebDriver getInstance() throws IOException
	{
		FileInputStream streamIn=new FileInputStream(conf);
		prop=new Properties();
		prop.load(streamIn);
		browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			dr=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriver"));
			dr=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("iedriver"));
			dr=new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgedriver"));
			dr=new EdgeDriver();
		}else
		{
			Throwable thr=new Throwable();
			thr.initCause(null);
		}
		dr.manage().window().maximize();
		dr.get(prop.getProperty("url"));
		return dr;
	}
	

}
