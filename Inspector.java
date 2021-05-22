package com.example.myapplication;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Inspector {

    AndroidDriver driver;

    public void Inspector(){}

    public  AndroidDriver getDriver(String appPackage, String appActivity) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Android Emulator
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        dc.setCapability("appPackage", appPackage);
        dc.setCapability("appActivity", appActivity); // This is Launcher activity of your app
        // (you can get it from apk info app)

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver driver = new AndroidDriver(url, dc);

        return driver;
    }
}
