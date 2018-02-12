package scenarios.web;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.SetupDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SiteTest extends SetupDriver{
    AndroidDriver driver;
    final String PROPERTIES = "/properties_web/web_test.properties";

    @BeforeClass
    public void setup(){
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), prepareDriver(PROPERTIES));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "some description")
    public void checkURL() {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), "Internet Assigned Numbers Authority");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
