package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

public class Driver extends TestProperties {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    protected DesiredCapabilities capabilities;

    // Properties to be read
    protected static String AUT; // (mobile) app under testing
    protected static String APP_ACTIVITY;
    protected static String APP_PACKAGE;
    protected static String SUT; // site under testing
    protected static String SUT_TITLE;
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String DEVICE_NAME;
    protected static String UDID;

    /**
     * Set appropriate capabilities to Appium driver depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        System.out.println("Properties: " + currentPropertyFile);

        // Assign property values to variables
        String resourcePath = "./src/main/resources/";
        String mobileAppName = getProp("aut");
        AUT = mobileAppName == null ? null : resourcePath + mobileAppName;
        System.out.println(AUT);
        String t_sut = getProp("sut");
        SUT = t_sut == null ? null : "https://" + t_sut;
        SUT_TITLE = getProp("title");
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("devicename");
        UDID = getProp("udid");
        APP_PACKAGE = getProp("appPackage");
        APP_ACTIVITY = getProp("appActivity");

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = "Chrome";
                break;
            case "iOS":
                capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, web (or hybrid)
        if (APP_ACTIVITY != null) {
            capabilities.setCapability("appPackage", APP_PACKAGE);
            capabilities.setCapability("appActivity", APP_ACTIVITY);
        } else {
            if (AUT != null && SUT == null) {
                // Native
                File app = new File(AUT);
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            } else if (SUT != null && AUT == null) {
                // Web
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
            } else {
                throw new Exception("Unclear type of mobile app");
            }
        }

        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);

        // Set an object to handle timeouts
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);

    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() throws Exception {
        //if(waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);
        return waitSingle;
    }

}
