package com.example.myapplication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ChromeTest {
    private AndroidDriver driver;

    @Test
    public void testAddition() throws InterruptedException, MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Android Emulator

        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");

        dc.setCapability("appPackage", "com.android.chrome");
        dc.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity"); // This is Launcher activity of your app
        // (you can get it from apk info app)

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AndroidDriver driver = new AndroidDriver(url, dc);

        //Thread.sleep(5000);
        TimeUnit.SECONDS.sleep(5);

        WebElement link2 = (WebElement) driver.findElementById("com.android.chrome:id/terms_accept");
        link2.click();
        WebElement link3 = (WebElement) driver.findElementById("com.android.chrome:id/next_button");
        link3.click();
        WebElement link4 = (WebElement) driver.findElementById("com.android.chrome:id/negative_button");
        link4.click();
        WebElement link5 = (WebElement) new WebDriverWait(driver, 15).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("com.android.chrome:id/search_box_text")));
        link5.sendKeys("appium testing");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement link6 = (WebElement) driver.findElementsById("com.android.chrome:id/line_1").get(0);
        link6.click();

        TimeUnit.SECONDS.sleep(5);
        //Thread.sleep(5000);
        driver.quit();
    }
}
