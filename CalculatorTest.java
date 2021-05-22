package com.example.myapplication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {
    private AndroidDriver driver;

    @Test
    public void testAddition() throws InterruptedException, MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Android Emulator

        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");

        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator"); // This is Launcher activity of your app
        // (you can get it from apk info app)

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver driver = new AndroidDriver(url, dc);

        //Thread.sleep(5000);
        TimeUnit.SECONDS.sleep(5);


        // locate the Text on the calculator by using By.name()
        WebElement seven = driver.findElementById("com.google.android.calculator:id/digit_7");
        seven.click();
        WebElement plus = driver.findElementById("com.google.android.calculator:id/op_add");
        plus.click();
        WebElement three = driver.findElementById("com.google.android.calculator:id/digit_3");
        three.click();
        WebElement equalTo = driver.findElementById("com.google.android.calculator:id/eq");
        equalTo.click();

        // locate the edit box
        WebElement results = (WebElement) driver.findElementById("com.google.android.calculator:id/result_final");

        if(results.getText().equals("10"))
        {
            System.out.println("Test Passed...");
        }
        else
        {
            System.out.println("Test Failed...");
        }
        Assert.assertEquals("10", results.getText(), "Result should be equals 10");

        driver.quit();
    }

}