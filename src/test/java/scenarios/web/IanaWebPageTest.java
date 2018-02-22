package scenarios.web;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.web.HomePage;

import static enums.driverSetup.TestsSettingsEnum.WEB_PROPERTY_ON_FARM_IOS;
import static enums.web.SitePageEnum.HOME_PAGE_TITLE;
import static setup.DriverSetup.*;

public class IanaWebPageTest {
    HomePage homePage;

    /**
     * uses to prepare AppiumDriver
     */
    @BeforeClass(alwaysRun = true)
    public void setup() {
        try {
//            prepareDriver(WEB_PROPERTY_ON_FARM_ANDROID.text);
            prepareDriver(WEB_PROPERTY_ON_FARM_IOS.text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getDriver().get(getUrl());
        homePage = new HomePage();
    }

    /**
     * uses to close resources
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getDriver().closeApp();
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
