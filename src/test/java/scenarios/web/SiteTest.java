package scenarios.web;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.DriverSetup;
import setup.SetupDriver;

import java.util.concurrent.TimeUnit;

import static enums.SitePageEnum.TITLE;
import static enums.TestsSettingsEnum.WEB_PROPERTY;

public class SiteTest {

    /**
     * uses to prepare AppiumDriver
     */
    @BeforeClass
    public void setup(){
        try {
            DriverSetup.prepareDriver(WEB_PROPERTY.text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DriverSetup.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        DriverSetup.driver.quit();
    }

    /**
     * uses for checking some functional on web site "https://www.iana.org".
     */
    @Test(description = "testing of web site", groups = "web")
    public void checkURL() {
        DriverSetup.driver.get(DriverSetup.url);
        Assert.assertEquals(DriverSetup.driver.getTitle(), TITLE.text);
    }
}
