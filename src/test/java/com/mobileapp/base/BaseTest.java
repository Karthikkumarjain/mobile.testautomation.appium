package com.mobileapp.base;

import com.mobileapp.utils.PropertyFileReader;

import com.mobileapp.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public AppiumDriver driver;
    public static ThreadLocal<AppiumDriver> driverThreadLocalServer = new ThreadLocal<>();
    private static AppiumDriverLocalService server;
    PropertyFileReader propertyFileReader = new PropertyFileReader();


    public static synchronized AppiumDriver getDriver() {

        return driverThreadLocalServer.get();
    }

    public void setDriver(AppiumDriver driver) {
        driverThreadLocalServer.set(driver);

    }

    public BaseTest() {

        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @Parameters({"emulator", "platformName", "udid", "deviceName", "systemPort",
            "chromeDriverPort", "wdaLocalPort", "webkitDebugProxyPort"})
    @BeforeTest
    public void setUp(@Optional("androidOnly") String emulator, String platformName, String udid, String deviceName,
                      @Optional("androidOnly") String systemPort, @Optional("androidOnly") String chromeDriverPort,
                      @Optional("iOSOnly") String wdaLocalPort, @Optional("iOSOnly") String webkitDebugProxyPort) {

        AppiumDriver driver1 = null;
        switch (platformName) {
            case "Android":
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName(platformName);
                options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
                options.setUdid(udid);
                options.setDeviceName(deviceName);
                options.setAppPackage(propertyFileReader.getValue("androidAppPackage"));
                options.setAppActivity(propertyFileReader.getValue("androidAppActivity"));
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
            case "iOS":
                XCUITestOptions options1 = new XCUITestOptions();
                options1.setPlatformName(platformName);
                options1.setAutomationName(AutomationName.IOS_XCUI_TEST);
                options1.setUdid(udid);
                options1.setDeviceName(deviceName);
                options1.setApp(propertyFileReader.getValue("iOSAppLocation"));

                try {
                    driver1 = new IOSDriver(new URL(propertyFileReader.getValue("appiumURL")), options1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "pcloudy":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("appium:newCommandTimeout", 600);
                capabilities.setCapability("appium:launchTimeout", 90000);
                capabilities.setCapability("appium:platformVersion", "11.0.0");
                capabilities.setCapability("appium:platformName", "Android");
                capabilities.setCapability("appium:automationName", "uiautomator2");
                capabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
                capabilities.setCapability("appium:appActivity", ".MainActivity");
                HashMap<String, Object> pcloudyOptions = new HashMap<String, Object>();
                pcloudyOptions.put("pCloudy_Username", "karthik.kumarb@thoughtworks.com");
                pcloudyOptions.put("pCloudy_ApiKey", "bvtjcg858v9bgr6f8cgg7tzp");
                pcloudyOptions.put("pCloudy_DurationInMinutes", 15);
                pcloudyOptions.put("pCloudy_DeviceFullName", "GOOGLE_Pixel2XL_Android_11.0.0_d22ac");
                pcloudyOptions.put("pCloudy_ApplicationName", "Android_MyDemoAppRNbuild.apk");
                pcloudyOptions.put("pCloudy_WildNet", "false");
                pcloudyOptions.put("pCloudy_EnableVideo", "false");
                pcloudyOptions.put("pCloudy_EnablePerformanceData", "false");
                pcloudyOptions.put("pCloudy_EnableDeviceLogs", "false");
                pcloudyOptions.put("appiumVersion", "2.0.0");
                capabilities.setCapability("pcloudy:options", pcloudyOptions);
                try {
                    driver1 = new AndroidDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new RuntimeException("Hey enter a proper value.The entered value is invalid" + platformName);

        }
        setDriver(driver1);


    }

    public void waitForVisibilityOfElement(WebElement e) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TestUtils.WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));

    }

    public void clickOnElement(WebElement e) {
        waitForVisibilityOfElement(e);
        e.click();

    }

    public void sendKeys(WebElement e, String str) {
        waitForVisibilityOfElement(e);
        e.sendKeys(str);

    }

    void clearText(WebElement e) {
        waitForVisibilityOfElement(e);
        e.clear();

    }

    public String getAttribute(WebElement e) {
        waitForVisibilityOfElement(e);
        String text = e.getText();
        return text;

    }

}
