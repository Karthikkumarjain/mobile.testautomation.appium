<?xml version="1.0" encoding="UTF-8"?>
<suite name="Suite" parallel="tests">
<test name="Pixel_5">
<listeners>
<listener class-name="com.qa.listeners.TestListener" />
</listeners>
<parameter name="emulator" value="true" />
<parameter name="platformName" value="Android" />
<parameter name="udid" value="emulator-5554" />
<parameter name="deviceName" value="Pixel_5" />
<parameter name="systemPort" value="10000" />
<parameter name="chromeDriverPort" value="11000" />
<classes>
<class name="com.qa.tests.LoginTests"/>
<class name="com.qa.tests.ProductTests"/>
</classes>
</test>
<test name="iPhone14ProMax">
<listeners>
<listener class-name="com.qa.listeners.TestListener" />
</listeners>
<parameter name="platformName" value="iOS" />
<parameter name="udid" value="00C33F13-93B4-4B19-8822-DA22D9F911C4" />
<parameter name="deviceName" value="iPhone 14 Pro Max" />
<parameter name="wdaLocalPort" value="10001" />
<parameter name="webkitDebugProxyPort" value="11001" />
<classes>
<class name="com.qa.tests.LoginTests"/>
<class name="com.qa.tests.ProductTests"/>
</classes>
</test>
</suite> <!-- Suite -->
<?xml version="1.0" encoding="UTF-8"?>
<suite name="Suite" parallel="tests">
    <test name="Pixel_5">
        <listeners>
            <listener class-name="com.qa.listeners.TestListener" />
        </listeners>
        <parameter name="emulator" value="true" />
        <parameter name="platformName" value="Android" />
        <parameter name="udid" value="emulator-5554" />
        <parameter name="deviceName" value="Pixel_5" />
        <parameter name="systemPort" value="10000" />
        <parameter name="chromeDriverPort" value="11000" />
        <classes>
            <class name="com.qa.tests.LoginTests"/>
            <class name="com.qa.tests.ProductTests"/>
        </classes>
    </test>
    <test name="iPhone14ProMax">
        <listeners>
            <listener class-name="com.qa.listeners.TestListener" />
        </listeners>
        <parameter name="platformName" value="iOS" />
        <parameter name="udid" value="00C33F13-93B4-4B19-8822-DA22D9F911C4" />
        <parameter name="deviceName" value="iPhone 14 Pro Max" />
        <parameter name="wdaLocalPort" value="10001" />
        <parameter name="webkitDebugProxyPort" value="11001" />
        <classes>
            <class name="com.qa.tests.LoginTests"/>
            <class name="com.qa.tests.ProductTests"/>
        </classes>
    </test>
</suite> <!-- Suite -->
