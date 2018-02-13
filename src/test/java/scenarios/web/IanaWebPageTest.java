package scenarios.web;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.web.*;
import static setup.DriverSetup.*;

import java.util.concurrent.TimeUnit;

import static enums.driverSetup.TestsSettingsEnum.WEB_PROPERTY;
import static enums.web.SitePageEnum.HOME_PAGE_TITLE;

public class IanaWebPageTest {
    HomePage homePage;

    /**
     * uses to prepare AppiumDriver
     */
    @BeforeClass
    public void setup() {
        try {
            prepareDriver(WEB_PROPERTY.text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
        homePage = new HomePage();
    }

    /**
     * uses to close resources
     */
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /**
     * uses for checking some functional on web site "https://www.iana.org".
     */
    @Test(description = "testing of web site", groups = "web")
    public void checkPageContent() {
        //check title
        homePage.checkUrl(HOME_PAGE_TITLE.text);

        //check characteristics of the central block title-links
        homePage.checkPageLinks();

        //check texts on central block
        homePage.checkTextsOnCentralBlocks();
    }
}
