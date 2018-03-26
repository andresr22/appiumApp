package com.appiumAndroid.classes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Gmail {
	
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
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy s8+");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.gm");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.gm.ConversationListActivityGmail");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    public void testGmail(String para, String asun, String mensa) {

        // How to click the first element in the search result
        driver.findElementById("com.google.android.gm:id/compose_button").click();
        driver.findElementById("com.google.android.gm:id/to").sendKeys(para + " \n");
        driver.findElementById("com.google.android.gm:id/subject").sendKeys(asun +"\n");
        driver.findElementById("com.google.android.gm:id/composearea_tap_trap_bottom").sendKeys(mensa +"\n");
        driver.findElementById("com.google.android.gm:id/send").click();
        System.out.println("Se envio tu mensaje");
        
 }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
