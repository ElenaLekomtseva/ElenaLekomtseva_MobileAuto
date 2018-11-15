package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.util.Map;

public class Driver {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    protected static Map<String, String> params;

    private static String host;
    private static String port;
    private static String platformName;

    private static void loadConfigurationXML() {
        host = params.get(Constants.HOST.get());
        port = params.get(Constants.PORT.get());
        platformName = params.get(Capabilities.PLATFORMNAME.get());
    }

    private static URL getAppiumServerURL() throws Exception {
        String remoteUrl = "http://" + host + ":" + port + "/wd/hub";
        URL url = new URL(remoteUrl);
        System.out.println("Expecting Appium server on --> " + remoteUrl);
        return url;
    }

    /**
     * Merges the capabilities into {@link DesiredCapabilities} object provided
     * 	 * in params.<br>
     */
    private static DesiredCapabilities capabilities() {
        String value = "";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (params.size() > 0) {
            for (Capabilities capability : Capabilities.values()) {
                value = params.get(capability.get());
                if (value != null) {
                    if (capability.get().equals(Capabilities.APP.get())) {
                        value = new File(value).getAbsolutePath();
                    }

                    capabilities.setCapability(capability.get(), value);
                    System.out.println("Appium capability was set --> " +
                            capability.get() + ":" + value);
                }
            }
        }
        return capabilities;
    }

    /**
     * Set appropriate capabilities to Appium driver depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        loadConfigurationXML();

        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) driverSingle = new AppiumDriver(getAppiumServerURL(), capabilities());

        // Set an object to handle timeouts
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);

    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) {
            prepareDriver();
        }
        return driverSingle;
    }

    protected WebDriverWait driverWait() throws Exception {
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), Constants.TIMEOUT.getInt());
        }
        return waitSingle;
    }

}
