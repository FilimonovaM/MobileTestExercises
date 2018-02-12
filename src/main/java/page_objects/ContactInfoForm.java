package page_objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static enums.ContactManagerEnum.CONTACT_NAME;
import static enums.ContactManagerEnum.CONTACT_PHONE;

public class ContactInfoForm {
    private final String PATH = "com.example.android.contactmanager:id/";
    private final String XPATH = "//android.widget.TextView[@content-desc=";
    private WebElement contactNameTextField;
    private WebElement contactNameTitle;
    private WebElement contactPhoneTextField;
    private WebElement contactPhoneTitle;

    public void checkContactNameForm(AndroidDriver driver) {
        contactNameTextField = driver.findElement(By.id(PATH + "contactNameEditText"));
        Assert.assertTrue(contactNameTextField.isDisplayed());

        contactNameTitle = driver.findElement(By.xpath(XPATH + "'Contact Name']"));
        Assert.assertTrue(contactNameTitle.isDisplayed());
        Assert.assertEquals(contactNameTitle.getText(), CONTACT_NAME.text);
    }

    public void checkContactPhoneForm(AndroidDriver driver) {
        contactPhoneTextField = driver.findElement(By.id(PATH + "contactPhoneEditText"));
        Assert.assertTrue(contactPhoneTextField.isDisplayed());

        contactPhoneTitle = driver.findElement(By.xpath(XPATH + "'Contact Phone']"));
        Assert.assertTrue(contactPhoneTitle.isDisplayed());
        Assert.assertEquals(contactPhoneTitle.getText(), CONTACT_PHONE.text);

    }
}
