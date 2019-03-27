package testing;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;


public class AppTest 
{
	 public static final String USERNAME = "anandbhayre123";
	  public static final String ACCESS_KEY = "cd8559eb-7fce-4115-8f71-920eb13a442f";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException, MalformedURLException
    {
    	 DesiredCapabilities capabilities = new DesiredCapabilities();
    	    capabilities.setCapability("platformName", "Android");
    	    capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
    	    capabilities.setCapability("platformVersion", "4.4");
    	    capabilities.setCapability("app", "https://www.dropbox.com/s/bajfukycchaxar8/zencsr.apk?dl=1");
    	    capabilities.setCapability("browserName", "");
    	    capabilities.setCapability("deviceOrientation", "portrait");
    	    capabilities.setCapability("appiumVersion", "1.6");
    	    capabilities.setCapability("appPackage", "com.zencsr.app");
    	    capabilities.setCapability("appActivity", "com.zencsr.app.MainActivity");
    	 
    	    WebDriver dr = new AndroidDriver<>(new URL(URL), capabilities);
    	    
    	    WebDriverWait wait = new WebDriverWait(dr, 60);
    		LocalTime localTime = LocalTime.now();
    		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
    		String s1 = localTime.format(dateTimeFormatter).toLowerCase();
    		System.out.println(s1);

    		System.out.println("Jyoti bankey testing");
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
    				"//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")))
    				.click();
    		
    		Thread.sleep(2000);
    		dr.findElement(By.className("android.view.View")).click();
    	//click on volunteering on home page
    		wait.until(
    				ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id='circle4']")));

    		dr.findElement(By.xpath("//android.widget.Button[@resource-id='circle4']")).click();
    		
    		// click on What can you do

    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@index='4']")));

    		dr.findElement(By.xpath("//android.view.View[@index='4']")).click();
    	 
    	    dr.quit();
    }
}
