package page_objects.contact_manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static setup.DriverSetup.*;
import static enums.ContactManagerEnum.*;

public class ContactInfoForm {
    private final String PATH = "com.example.android.contactmanager:id/";
    private final String XPATH = "//android.widget.TextView[@content-desc=";
    private WebElement contactNameTextField;
    private WebElement contactNameTitle;
    private WebElement contactPhoneTextField;
    private WebElement contactPhoneTitle;
    private WebElement contactEmailTextField;
    private WebElement contactEmailTitle;
    private WebElement submitButton;

    /**
     * uses to check the keyboard.
     *
     * -it can be used
     *
     * @param text - text for typing
     * @param webElement - target text field
     */
    public void checkFieldsWithKeyboard(String text, WebElement webElement){
        webElement.click();
        driver.getKeyboard().sendKeys(text);
        Assert.assertEquals(webElement.getText(), text);
    }

    /**
     * uses to check the Name Field and it`s title.
     *
     * -right title
     * -visible
     * -enable
     */
    public void checkNameForm() {
        //title
        contactNameTitle = driver.findElement(By.xpath(XPATH + "'Contact Name']"));
        assert contactNameTitle.isDisplayed() : "Title of 'Contact Name' text field is invisible";
        Assert.assertEquals(contactNameTitle.getText(), CONTACT_NAME.text);

        //text field
        contactNameTextField = driver.findElement(By.id(PATH + "contactNameEditText"));
        assert  contactNameTextField.isDisplayed() : "Text field 'Contact Name' is invisible";
        assert  contactNameTextField.isEnabled() : "Text field 'Contact Name' is not enabled";

        //send keys by keyboard
        contactNameTextField.click();
        checkFieldsWithKeyboard(CONTACT_NAME.user, contactNameTextField);
    }

    /**
     * uses to check the Phone Field and it`s title.
     * -right title
     * -visible
     * -enable
     */
    public void checkPhoneForm() {
        //title
        contactPhoneTitle = driver.findElement(By.xpath(XPATH + "'Contact Phone']"));
        assert contactPhoneTitle.isDisplayed() : "Title of 'Contact Phone' text field is invisible";;
        Assert.assertEquals(contactPhoneTitle.getText(), CONTACT_PHONE.text);

        //text field
        contactPhoneTextField = driver.findElement(By.id(PATH + "contactPhoneEditText"));
        assert contactPhoneTextField.isDisplayed() : "Text field 'Contact Phone' is invisible";

        //send keys by keyboard
        contactNameTextField.click();
        checkFieldsWithKeyboard(CONTACT_PHONE.user, contactPhoneTextField);
    }

    /**
     * uses to check the Phone Field and it`s title.
     * -right title
     * -visible
     * -enable
     * @param driver - used driver
     */
    public void checkEmailForm() {
        //title
        contactEmailTitle = driver.findElement(By.xpath(XPATH + "'Contact Email']"));
        assert contactEmailTitle.isDisplayed() : "Title of 'Contact Phone' text field is invisible";;
        Assert.assertEquals(contactPhoneTitle.getText(), CONTACT_PHONE.text);

        //text field
        contactEmailTextField = driver.findElement(By.id(PATH + "contactEmailEditText"));
        assert contactEmailTextField.isDisplayed() : "Text field 'Contact Phone' is invisible";

        //send keys by keyboard
        contactEmailTextField.click();
        checkFieldsWithKeyboard(CONTACT_EMAIL.user, contactEmailTextField);
    }

    public void checkSubmitButton(){
        submitButton = driver.findElement(By.id(PATH + "contactSaveButton"));
        assert submitButton.isDisplayed() : "Submit button is not displayed";
        Assert.assertEquals(submitButton.getText(), "Save");
        assert submitButton.isEnabled() :"Submit button is not enabled";
        submitButton.click();
    }
}
