package page_objects.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static enums.web.SitePageEnum.*;
import static setup.DriverSetup.*;

public class HomePage extends WebPage {
    private WebElement domainNamesLink;
    private WebElement numberResourcesLink;
    private WebElement protocolAssignmentsLink;

    private WebElement domainNamesTextField;
    private WebElement numberResourcesTextField;
    private WebElement protocolAssignmentsTextField;

    /**
     * uses to check the url after driver navigation.
     *
     * @param url - expected  new url
     */
    @Override
    public void checkUrl(String url) {
        Assert.assertEquals(getDriver().getTitle(), url);
    }

    /**
     * uses to check links functionality for 3 big blocks(DOMAIN, NUMBER_RESOURCES, PROTOCOL).
     * <p>
     * -check title name & other specifications of elements
     * uses dynamic search - or selenium throw StaleElementReferenceException
     */
    public void checkPageLinks() {
        domainNamesLink = getDriver().findElementByCssSelector("#home-panel-domains a");
        numberResourcesLink = getDriver().findElementByCssSelector("#home-panel-numbers a");
        protocolAssignmentsLink = getDriver().findElementByCssSelector("#home-panel-protocols a");

        //check titles of blocks
        Assert.assertEquals(domainNamesLink.getText(), DOMAIN_TITLE.text);
        Assert.assertEquals(numberResourcesLink.getText(), NUMBER_RESOURCES_TITLE.text);
        Assert.assertEquals(protocolAssignmentsLink.getText(), PROTOCOL_ASSIGNMENTS_TITLE.text);

        //DOMAIN block
        checkLinkActivityOnClick(getDriver().findElementByCssSelector("#home-panel-domains a"), new DomainPage(),
                DOMAIN.text);
        //NUMBER_RESOURCES block
        checkLinkActivityOnClick(getDriver().findElementByCssSelector("#home-panel-numbers a"),
                new NumberResourcesPage(), NUMBER_RESOURCES.text);
        //PROTOCOL block
        checkLinkActivityOnClick(getDriver().findElementByCssSelector("#home-panel-protocols a"),
                new ProtocolPage(), PROTOCOL.text);
    }

    /**
     * uses to check links functionality.
     * <p>
     * -element is visible
     * -element is enabled
     * -click
     * -move to other page
     * -check the link
     * -back to HOME page
     *
     * @param element - chosen link
     * @param page    - page object of page which situated on the opposite side of the link way
     * @param url     - expected  new url
     */
    private void checkLinkActivityOnClick(WebElement element, WebPage page, String url) {
        assert element.isDisplayed() : element.getText() + " - invisible!!!";
        assert element.isEnabled() : element.getText() + " - isn`t enabled!!!";
        element.click();
        page.checkUrl(url);
        //wait the page-loading for the correct work with next elements
        getWebDriverWait().until(ExpectedConditions.urlToBe(HOME.text));
    }

    /**
     * uses for checking the texts of 3 big blocks(DOMAIN, NUMBER_RESOURCES, PROTOCOL).
     * <p>
     * -right texts
     * -visible
     */
    public void checkTextsOnCentralBlocks() {
        domainNamesTextField = getDriver().findElementByCssSelector("#home-panel-domains");
        numberResourcesTextField = getDriver().findElementByCssSelector("#home-panel-numbers");
        protocolAssignmentsTextField = getDriver().findElementByCssSelector("#home-panel-protocols");

        assert domainNamesTextField.isDisplayed() : "'Domain' Text Field - invisible!!!";
        Assert.assertEquals(domainNamesTextField.getText(), DOMAIN_BLOCK_TEXT.text);

        assert numberResourcesTextField.isDisplayed() : "'Number_Resources' Text Field - invisible!!!";
        Assert.assertEquals(numberResourcesTextField.getText(), NUMBER_RESOURCES_BLOCK_TEXT.text);

        assert protocolAssignmentsTextField.isDisplayed() : "'Protocol_Assignments' Text Field - invisible!!!";
        Assert.assertEquals(protocolAssignmentsTextField.getText(), PROTOCOL_BLOCK_TEXT.text);
    }
}
