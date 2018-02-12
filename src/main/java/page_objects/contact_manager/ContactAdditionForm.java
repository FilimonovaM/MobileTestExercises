package page_objects.contact_manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactAdditionForm {

    private WebElement additionContactButton;

    public void checkTheButton(AppiumDriver driver){
        additionContactButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Add Contact']"));
        assert additionContactButton.isDisplayed() : "Button 'Add Contact' is not Displayed";
        additionContactButton.click();
    }
}
