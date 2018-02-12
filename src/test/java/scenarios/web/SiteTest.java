package scenarios.web;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.SetupDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static enums.SitePageEnum.TITLE;
import static enums.TestsSettingsEnum.APPIUM_LOCALHOST;
import static enums.TestsSettingsEnum.WEB_PROPERTY;

public class SiteTest extends SetupDriver{
    AppiumDriver driver;

    /**
     * uses to prepare AppiumDriver
     */
    @BeforeClass
    public void setup(){
        try {
            driver = new AppiumDriver(new URL(APPIUM_LOCALHOST.text), prepareDriverSettings(WEB_PROPERTY.text));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * uses for checking some functional on web site "https://www.iana.org".
     */
    @Test(description = "testing of web site")
    public void checkURL() {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), TITLE.text);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
