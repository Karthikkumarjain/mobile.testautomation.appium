import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"pixel_7");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/ApiDemos-debug.apk");


        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url,capabilities);

    }
}

class CreateDriverSessionAsPerLatest2{

    public static void main(String[] args) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("pixel_7");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setUdid("emulator-5554");
        options.setApp("/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/ApiDemos-debug.apk");

        new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

    }

}


class CreateDriverSessionAsPerLatest2iOS{

    public static void main(String[] args) throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        options.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 14 Pro Max");
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
        options.setCapability(MobileCapabilityType.UDID,"98449E1B-3023-4EE8-A33E-3B2615D44756");
        options.setCapability(MobileCapabilityType.APP,"/Users/karthik.kumarb/workspace/personal/mobile.testautomation.appium/src/test/resources/UIKitCatalog-iphonesimulator.app");

        new IOSDriver(new URL("http://127.0.0.1:4723"),options);

    }

}

