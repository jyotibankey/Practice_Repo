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
import io.appium.java_client.android.AndroidKeyCode;

public class AppTest {
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
   	    capabilities.setCapability("app", "https://www.dropbox.com/s/yaxchprwkbhj589/LoanEMICalc.apk?dl=1");
   	    capabilities.setCapability("browserName", "");
   	    capabilities.setCapability("deviceOrientation", "portrait");
   	    capabilities.setCapability("appiumVersion", "1.6");
   	    capabilities.setCapability("appPackage", "com.arbapps.loanemicalc");
		capabilities.setCapability("appActivity", ".MainScreen");
   	 
   	    WebDriver dr = new AndroidDriver<>(new URL(URL), capabilities);
   	    
   	 WebDriverWait wait= new WebDriverWait(dr, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.arbapps.loanemicalc:id/loanemicalc")));
		
		dr.findElement(By.id("com.arbapps.loanemicalc:id/loanemicalc")).click();
				
		Thread.sleep(3000); 
		dr.findElement(By.xpath("//android.widget.EditText[@resource-id='com.arbapps.loanemicalc:id/principal_amount']")).sendKeys("40000");
		
		dr.findElement(By.xpath("//android.widget.EditText[@index='3']")).sendKeys("8");
		
		dr.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys("8");
		
		((AndroidDriver)dr).pressKeyCode(AndroidKeyCode.BACK);
		
		dr.findElement(By.id("com.arbapps.loanemicalc:id/loanaffordcalc")).click();
		
		dr.findElement(By.xpath("//android.widget.EditText[@resource-id='com.arbapps.loanemicalc:id/afford_emi']")).sendKeys("40000");
		
		dr.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys("8");
		
		dr.findElement(By.xpath("//android.widget.EditText[@index='5']")).sendKeys("8");
   }
}
