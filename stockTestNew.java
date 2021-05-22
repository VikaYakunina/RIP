package com.example.myapplication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class stockTestNew {
    private AndroidDriver driver;

    @Test
    public void testAddition() throws InterruptedException, MalformedURLException {

        Inspector inspector=new Inspector();
        AndroidDriver driver=inspector.getDriver("com.investorvista.stockspyod","com.investorvista.MainActivity");

        //Thread.sleep(5000);
        TimeUnit.SECONDS.sleep(5);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement link1 = (WebElement) driver.findElementById("com.investorvista.stockspyod:id/symbolList_leftSort");
        link1.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement link2 = (WebElement) driver.findElementById("com.investorvista.stockspyod:id/symbolLookupButton");
        link2.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement link3 = (WebElement) new WebDriverWait(driver, 15).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("com.investorvista.stockspyod:id/symbolLookupField")));
        link3.sendKeys("USA");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement link4 = (WebElement) driver.findElementById("com.investorvista.stockspyod:id/symbolLookupGo");
        link4.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //WebElement link5 = (WebElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ExpandableListView/android.view.ViewGroup[3]");
        //link5.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement link5 = (WebElement) driver.findElementsById("com.investorvista.stockspyod:id/newsItemDescription").get(1);
        link5.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement link6 = (WebElement) driver.findElementById("com.investorvista.stockspyod:id/symbolDetailsBack");
        link6.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement link7 =  driver.findElementById("com.investorvista.stockspyod:id/symbollistSettingsButton");
        link7.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement link8 = (WebElement) driver.findElementById("com.investorvista.stockspyod:id/settingsDoneButton");
        link8.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Thread.sleep(5000);
        TimeUnit.SECONDS.sleep(5);

        driver.quit();
    }
}
