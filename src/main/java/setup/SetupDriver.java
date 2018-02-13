package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ReadProperties;

import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static enums.BrowsersEnum.*;
import static enums.PlatformsEnum.*;
import static enums.CommonInfoEnum.*;

public class SetupDriver {
    private DesiredCapabilities capabilities;
    private Properties properties;
    protected AppiumDriver driver;
    protected String url;

    /**
     * uses to configure & init AppiumDriver
     */
    protected void prepareDriver(String property) throws Exception {
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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
