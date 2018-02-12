package page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.SelendroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactAdditionForm {

    private WebElement additionContactButton;

    public void checkTheButton(AppiumDriver driver){
        additionContactButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Add Contact']"));
        additionContactButton.click();
        Assert.assertTrue(additionContactButton.isDisplayed());
    }
}
