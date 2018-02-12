package setup;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ReadProperties;

import java.io.File;
import java.util.Properties;

//TODO: driver
public class SetupDriver {
    protected WebDriverWait webDriverWait;
    protected DesiredCapabilities capabilities;
    protected String url;
    private Properties properties;

    protected DesiredCapabilities prepareDriverSettings(String propertyFile) throws Exception {
        properties = ReadProperties.getCurrentProp(propertyFile);
        capabilities = new DesiredCapabilities();

        if (properties != null) {
            if (properties.containsKey("sut")) {
                url = "http://" + properties.getProperty("sut");
                if (properties.getProperty("platformName").equalsIgnoreCase("Android")) {
                    properties.setProperty("browserName", "Chrome");
                } else if (properties.getProperty("platformName").equalsIgnoreCase("iOS")) {
                    properties.setProperty("browser", "Safari");
                } else {
                    throw new Exception("Unknown platform");
                }
            } else if (properties.containsKey("app")) {
                properties.setProperty("app", new File(properties.getProperty("app")).getAbsolutePath());
            }
            properties.forEach((key, value) -> {
                if (!key.toString().equalsIgnoreCase("sut")) {
                    capabilities.setCapability((String) key, (String) value);
                }
            });
        }
        return capabilities;
    }
}
