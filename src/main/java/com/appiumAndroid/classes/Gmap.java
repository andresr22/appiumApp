package com.appiumAndroid.classes;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Gmap {
	
	private AppiumDriver driver;
	private WebDriverWait webDriverWait;
	List<MobileElement> listOfResults;
	String resName;
	MobileElement element;
	
    public void setup(String v) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, v);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S8+");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.maps");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.maps.MapsActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        webDriverWait = new WebDriverWait(driver, 30);
    }
    
    public void testGmap(String s) {
    	
        driver.findElementById("com.google.android.apps.maps:id/search_omnibox_text_box").click();
        driver.findElementById("com.google.android.apps.maps:id/search_omnibox_edit_text").sendKeys(s);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.maps:id/recycler_view")));
        listOfResults = driver.findElementsById("com.google.android.apps.maps:id/title");
        for (MobileElement e : listOfResults) {
            System.out.println("Restaurant Name : " + e.getText().toString() + "\n");
        }
        resName = listOfResults.get(0).getText();
        listOfResults.get(0).click();
        element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + resName + "\");"));
        
    }
    
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
