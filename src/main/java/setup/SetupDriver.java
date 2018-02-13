package setup;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ReadProperties;

import java.io.File;
import java.util.Properties;

import static enums.BrowsersEnum.*;
import static enums.PlatformsEnum.*;
import static enums.CommonInfoEnum.*;

//TODO: driver
public class SetupDriver {
    protected WebDriverWait webDriverWait;
    protected DesiredCapabilities capabilities;
    protected String url;
    protected String host;
    protected Properties properties;

    protected DesiredCapabilities prepareDriverSettings(String propertyFile) throws Exception {
        properties = ReadProperties.getCurrentProp(propertyFile);
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
                if (!key.toString().equalsIgnoreCase(URL_MASK.text)&&!key.toString().equalsIgnoreCase(HOST_MASK.text)) {
                    capabilities.setCapability((String) key, (String) value);
                }
            });
        }
        return capabilities;
    }
}
