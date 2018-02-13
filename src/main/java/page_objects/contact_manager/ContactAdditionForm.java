package page_objects.contact_manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import setup.DriverSetup;

public class ContactAdditionForm {

    private WebElement additionContactButton;

    /**
     * uses for checking the "Add Contact" button properties.
     * -exist
     * -visible
     * -right name
     * -enable
     */
    public void checkAdditionalButton(){
        additionContactButton = DriverSetup.driver.findElement(By.xpath("//android.widget." +
                "Button[@content-desc='Add Contact']"));
        assert additionContactButton.isDisplayed() : "Button 'Add Contact' is not Displayed";
        Assert.assertEquals(additionContactButton.getText(), "Add Contact");
        assert additionContactButton.isEnabled() : "Button 'Add Contact' is not Enabled";
        additionContactButton.click();
    }
}
