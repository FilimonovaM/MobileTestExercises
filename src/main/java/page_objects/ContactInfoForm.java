package page_objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.SelendroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactInfoForm {
    final String PATH = "com.example.android.contactmanager:id/";

    private WebElement contactNameTextField;

    @SelendroidFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Name']")
    private WebElement contactNameTitle;

    private WebElement contactPhoneTextField;

    @SelendroidFindBy(xpath = "//android.widget.TextView[@content-desc='Contact Number']")
    private WebElement contactPhoneTitle;

    public void checkContactNameForm(AndroidDriver driver) {
        contactNameTextField = driver.findElement(By.id(PATH + "contactNameEditText"));
        Assert.assertTrue(contactNameTextField.isDisplayed());

        contactNameTitle = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Contact Name']"));
        Assert.assertTrue(contactNameTitle.isDisplayed());
        Assert.assertEquals(contactNameTitle.getText(), "Contact Name");
    }

    public void checkContactPhoneForm(AndroidDriver driver) {
        contactPhoneTextField = driver.findElement(By.id(PATH + "contactPhoneEditText"));
        Assert.assertTrue(contactPhoneTextField.isDisplayed());

        contactPhoneTitle = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Contact Phone']"));
        Assert.assertTrue(contactPhoneTitle.isDisplayed());
        Assert.assertEquals(contactPhoneTitle.getText(), "Contact Phone");
    }
}
