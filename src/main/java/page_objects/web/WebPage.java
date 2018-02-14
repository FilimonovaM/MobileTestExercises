package page_objects.web;

import org.testng.Assert;

import static setup.DriverSetup.getDriver;

public class WebPage {
    /**
     * uses to check the url after driver navigation.
     *
     * @param url - expected  new url
     */
    public void checkUrl(String url) {
        Assert.assertEquals(url, getDriver().getCurrentUrl());
        getDriver().navigate().back();
    }
}
