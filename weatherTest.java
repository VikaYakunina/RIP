package com.example.myapplication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class weatherTest {
    private AndroidDriver driver;

    @Test
    public void testAddition() throws InterruptedException, MalformedURLException {

        Inspector inspector=new Inspector();
        AndroidDriver driver=inspector.getDriver("ru.rp5.rp5weatherhorizontal","ru.rp5.rp5weatherhorizontal.screen.StartUp");

        TimeUnit.SECONDS.sleep(5);
        //Thread.sleep(5000);

        WebElement link1 = (WebElement) driver.findElementById("ru.rp5.rp5weatherhorizontal:id/innerText");
        link1.click();
        WebElement link2 = (WebElement) driver.findElementById("ru.rp5.rp5weatherhorizontal:id/sixDays");
        link2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement link3 = (WebElement) driver.findElementById("ru.rp5.rp5weatherhorizontal:id/now");
        link3.click();
        WebElement link4 = (WebElement) driver.findElementById("ru.rp5.rp5weatherhorizontal:id/search");
        link4.click();
        WebElement link5 = (WebElement) new WebDriverWait(driver, 15).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("android:id/search_src_text")));
        link5.sendKeys("miami");
        WebElement link6 = (WebElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView");
        link6.click();
        //Thread.sleep(5000);
        TimeUnit.SECONDS.sleep(5);

        driver.quit();
    }
}
