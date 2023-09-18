package com.saucelab.base;

import com.saucelab.utils.PropertyFileReader;

import com.saucelab.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public  AppiumDriver driver;
    public static ThreadLocal<AppiumDriver> driverThreadLocalServer = new ThreadLocal<>();
    PropertyFileReader propertyFileReader = new PropertyFileReader();


    public static synchronized AppiumDriver getDriver() {

        return driverThreadLocalServer.get();
    }

    public void setDriver(AppiumDriver driver){
    driverThreadLocalServer.set(driver);

    }
    public BaseTest(){

        PageFactory.initElements(new AppiumFieldDecorator(getDriver()),this);
    }

    @Parameters({"emulator", "platformName", "udid", "deviceName", "systemPort",
            "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeTest
    public void setUp(@Optional("androidOnly")String emulator, String platformName, String udid, String deviceName,
               @Optional("androidOnly")String systemPort, @Optional("androidOnly")String chromeDriverPort,
               @Optional("iOSOnly")String wdaLocalPort, @Optional("iOSOnly")String webkitDebugProxyPort) {

        AppiumDriver driver1 = null;
        switch (platformName) {
            case "Android":
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName(AutomationName.ANDROID_UIAUTOMATOR2);
                options.setUdid(udid);
                options.setDeviceName(deviceName);
                if (emulator.equalsIgnoreCase("true")) {
                    options.setCapability("avd", deviceName);
                    options.setCapability("avdLaunchTimeout", 120000);
                }
                options.setApp(propertyFileReader.getValue("androidAppLocation"));
                try {
                    driver1 = new AndroidDriver(new URL(propertyFileReader.getValue("appiumURL")), options);
                } catch
                (Exception e) {
                    e.printStackTrace();
                }
                break;

        }
        setDriver(driver1);


    }


    public void waitForVisibilityOfElement(WebElement e){
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TestUtils.WAIT));
    wait.until(ExpectedConditions.visibilityOf(e));

}

public void clickOnElement(WebElement e){
        waitForVisibilityOfElement(e);
        e.click();

}

    public void sendKeys(WebElement e,String str){
        waitForVisibilityOfElement(e);
        e.sendKeys(str);

    }

    void clearText(WebElement e){
        waitForVisibilityOfElement(e);
        e.clear();

    }

    public String getAttribute(WebElement e){
        waitForVisibilityOfElement(e);
        String text = e.getText();
        return text;

    }
}
