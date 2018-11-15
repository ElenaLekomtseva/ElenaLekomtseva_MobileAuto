package setup;

/**
 * Holds Appium server capabilities.<br>
 * For more details see <a href="http://appium.io/slate/en/master
 * /?java#appium-server-capabilities">Appium server capabilities</a>
 */
public enum Capabilities {
    /** Name of mobile web browser to automate. */
    BROWSER_NAME("browserName"),
    /** Which mobile OS platform to use. */
    PLATFORMNAME("platformName"),
    /** The absolute local path to an .ipa or .apk file. */
    APP("app"),
    /** The kind of mobile device or emulator to use. */
    DEVICE_NAME("deviceName"),
    /** Unique device identifier of the connected physical device. */
    UDID("udid"),
    /** Name for the Android activity you want to launch (Android only). */
    APP_ACTIVITY("appActivity"),
    /** Java package of the Android app you want to run (Android only). */
    APP_PACKAGE("appPackage");

    private String myCapability;

    Capabilities(String caps) {
        myCapability = caps;
    }

    public String get() {
        return myCapability;
    }
}
