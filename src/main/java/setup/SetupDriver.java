package setup;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ReadProperties;

import java.util.Properties;

public class SetupDriver {
    protected WebDriverWait wait;
    protected DesiredCapabilities capabilities;
    private Properties properties;

    protected DesiredCapabilities prepareDriver(String propertyFile) throws Exception {
        properties = ReadProperties.getCurrentProp(propertyFile);
        capabilities = new DesiredCapabilities();
        if (properties != null) {
            if (properties.containsKey("sut")) {
                if (properties.getProperty("paltformName").equalsIgnoreCase("Android")) {
                    properties.setProperty("browser", "Chrome");
                } else if (properties.getProperty("paltformName").equalsIgnoreCase("Ios")) {
                    properties.setProperty("browser", "Safari");
                } else {
                    throw new Exception("Unknown platform");
                }
            }
            properties.forEach((key, value) -> capabilities.setCapability((String) key, (String) value));
        }
        return capabilities;
    }
}
