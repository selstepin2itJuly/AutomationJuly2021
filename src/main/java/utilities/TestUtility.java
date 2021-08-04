package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase{

	public static void scrollToElement(WebElement e)
	{
		JavascriptExecutor j=(JavascriptExecutor) dr;
		j.executeScript("arguments[0].scrollIntoView(false);", e);
		j.executeScript("window.scrollBy(0,300)", "");
	}
	
	public static void clickOnElementJS(WebElement e)
	{
		JavascriptExecutor j=(JavascriptExecutor) dr;
		j.executeScript("arguments[0].click();", e);
	}
	
	public static void waitForElement(WebElement e)
	{
		WebDriverWait w=new WebDriverWait(dr, 15);
		w.until(ExpectedConditions.visibilityOf(e));
	}
	
	public static void waitForElementClickable(WebElement e)
	{
		WebDriverWait w=new WebDriverWait(dr, 15);
		w.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public static void captureScreen() throws IOException
	{
		TakesScreenshot c=(TakesScreenshot) dr;
		File file = c.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("image_"+getDateTime()+".jpg"));//jpg, png
	}
	
	//Futrue use in framework dev with testNG
	public static void attachScreenshot() throws IOException
	{
		TakesScreenshot c=(TakesScreenshot) dr;
		String file = c.getScreenshotAs(OutputType.BASE64);
		String st= "<img src=\"data:image/png;base64, " + file + "\" height=\"600\" width=\"800\" />";
		Reporter.log(st);
	}
	public static String getDateTime()
    {
    	String str = null;
    	Date d=new Date();
    	System.out.println(d);
    	SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MMM_dd_HH_mm_ss_SSS");
    	str=sdf.format(d);
    	System.out.println(str);
    	return str;
    	
    }
}
