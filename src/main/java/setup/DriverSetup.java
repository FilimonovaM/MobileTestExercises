package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utile.ReadProperties;

import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static enums.BrowsersEnum.BROWSER_MASK;
import static enums.BrowsersEnum.CHROME;
import static enums.BrowsersEnum.SAFARI;
import static enums.CommonInfoEnum.*;
import static enums.CommonInfoEnum.HOST_MASK;
import static enums.PlatformsEnum.*;

public class DriverSetup {
    private static DriverSetup ourInstance = new DriverSetup();

    public static DriverSetup getInstance() {
        return ourInstance;
    }

    private DriverSetup() {
    }

    private static DesiredCapabilities capabilities;
    private static Properties properties;
    public static AppiumDriver driver;
    public static String url;

    /**
     * uses to configure & init AppiumDriver
     */
    static public void prepareDriver(String property) throws Exception {
        properties = ReadProperties.getCurrentProp(property);
        capabilities = new DesiredCapabilities();

        if (properties != null) {
            if (properties.containsKey(URL_MASK.text)) {
                url = URL_PREFIX + properties.getProperty(URL_MASK.text);
                if (properties.getProperty(PLATFORM_MASK.text).equalsIgnoreCase(ANDROID.text)) {
                    properties.setProperty(BROWSER_MASK.text, CHROME.text);
                } else if (properties.getProperty(PLATFORM_MASK.text).equalsIgnoreCase(IOS.text)) {
                    properties.setProperty(BROWSER_MASK.text, SAFARI.text);
                } else {
                    throw new Exception(UNKNOWN_PLATFORM.text);
                }
            } else if (properties.containsKey(APP_MASK.text)) {
                properties.setProperty(APP_MASK.text, new File(properties.getProperty(APP_MASK.text)).getAbsolutePath());
            }
            properties.forEach((key, value) -> {
                if (!key.toString().equalsIgnoreCase(URL_MASK.text) && !key.toString().equalsIgnoreCase(HOST_MASK.text)) {
                    capabilities.setCapability((String) key, (String) value);
                }
            });
        }
        driver = new AppiumDriver(new URL(properties.getProperty(HOST_MASK.text)),
                capabilities);
    }
}
