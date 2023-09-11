package appiumtests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CalculatorTest {

	public static void main(String[] args) {
		 openCalculator(); // Call the openCalculator() method to start the test
    }

    public static void openCalculator() {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Pixel 6 API 31");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");

        cap.setCapability("appPackage", "com.google.android.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        String u = "http://127.0.0.1:4723/wd/hub";
        URL url = null;
        try {
            url = new URL(u);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
      

        AppiumDriver driver = new AndroidDriver(url, cap);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        try {
        	
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("digit_7")));
			element.click();
			WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("op_add")));
			element1.click();
			WebElement element2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("digit_3")));
			element2.click();
			WebElement element3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("eq")));
			element3.click();
			WebElement element4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("result_final")));
			

            String result = element4.getText();
            System.out.println("Calculation Result: " + result);
        } catch (TimeoutException e) {
            System.out.println("Element not found within timeout.");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            if (driver != null) {
                driver.quit();
            }
        }
    }
}