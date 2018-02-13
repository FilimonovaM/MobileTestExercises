package page_objects.web;

import org.testng.Assert;

import static setup.DriverSetup.driver;

public class WebPage {
    /**
     * uses to check the url after driver navigation.
     *
     * @param url - expected  new url
     */
    public void checkUrl(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
        driver.navigate().back();
    }
}
