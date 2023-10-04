package com.mobileapp.tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RandomTests {
    //UIAutomator2 -- https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
    //XCUITest -https://appium.github.io/appium-xcuitest-driver/5.2/execute-methods/#mobile-scroll


    @Test
    void andoirdlongClick() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("pixel_7");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp("/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/ApiDemos-debug.apk");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();


        //way 1
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"))).getId(), "duration", 1000
        ));

//way2
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", 223,
                "y", 590,
                "duration", 1000));

    }


    @Test
    void clickGesture() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("pixel_7");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp("/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/ApiDemos-debug.apk");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));


        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));

    }

    @Test
    void dragAndDrop() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("pixel_7");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp("/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/ApiDemos-debug.apk");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement toDrag = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) toDrag).getId(),
                "endX", 649,
                "endY", 662
        ));

    }

    @Test
    void swipeGesture() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("pixel_7");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp("/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/ApiDemos-debug.apk");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/content"));

        // WebElement toDrag = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                //  "left", 100, "top", 100, "width", 600, "height", 600,
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                //  "left", 100, "top", 100, "width", 600, "height", 600,
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 0.75
        ));

    }


    @Test
    void swipeLeft() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("pixel_7");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp("/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/ApiDemos-debug.apk");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/content"));

        // WebElement toDrag = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 600, "height", 600,
                //  "elementId",((RemoteWebElement)element).getId(),
                "direction", "left",
                "percent", 0.75
        ));


    }


    @Test
    void scroll() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("pixel_7");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp("/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/ApiDemos-debug.apk");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        // driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Graphics")).click();

        boolean canScrollMore = true;

        while (canScrollMore) {

            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 600, "height", 600,
                    "direction", "down",
                    "percent", 1.0
            ));
            System.out.println(canScrollMore);
        }

    }

    @Test
    void iOSswipeTest() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        options.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        options.setCapability(MobileCapabilityType.UDID, "98449E1B-3023-4EE8-A33E-3B2615D44756");
        options.setCapability(MobileCapabilityType.APP, "/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/UIKitCatalog-iphonesimulator.app");

        AppiumDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("velocity", 2500);
        //    params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);

    }

    @Test
    void iOSwipeTest() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        options.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        options.setCapability(MobileCapabilityType.UDID, "98449E1B-3023-4EE8-A33E-3B2615D44756");
        options.setCapability(MobileCapabilityType.APP, "/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/UIKitCatalog-iphonesimulator.app");

        AppiumDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("velocity", 2500);
        //    params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);


    }

    @Test
    void iOScrollTest() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        options.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        options.setCapability(MobileCapabilityType.UDID, "98449E1B-3023-4EE8-A33E-3B2615D44756");
        options.setCapability(MobileCapabilityType.APP, "/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/UIKitCatalog-iphonesimulator.app");

        AppiumDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        //params.put("velocity", 2500);
        //    params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: scroll", params);

    }


    @Test
    void zoomInZoomOut() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        options.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        options.setCapability(MobileCapabilityType.UDID, "98449E1B-3023-4EE8-A33E-3B2615D44756");
        // options.setCapability(MobileCapabilityType.APP, "/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/UIKitCatalog-iphonesimulator.app");
        options.setCapability("bundleId", "com.apple.Maps");
        AppiumDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        Map<String, Object> params = new HashMap<>();
        params.put("scale", 5);
        params.put("velocity", 2.2);
        //    params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: pinch", params);


        Map<String, Object> params1 = new HashMap<>();
        params1.put("scale", 0.5);
        params1.put("velocity", -2);
        //    params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: pinch", params1);

    }


    @Test
    void touchAndHold() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        options.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        options.setCapability(MobileCapabilityType.UDID, "98449E1B-3023-4EE8-A33E-3B2615D44756");
        options.setCapability(MobileCapabilityType.APP, "/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/app/UIKitCatalog-iphonesimulator.app");

        AppiumDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();

        WebElement element = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"Increment\"])[1]"));

        Map<String, Object> params = new HashMap<>();
        params.put("duration", 5);

        params.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: touchAndHold", params);


    }

}


