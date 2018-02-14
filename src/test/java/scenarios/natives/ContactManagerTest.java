package scenarios.natives;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.contact_manager.ContactAdditionForm;
import page_objects.contact_manager.ContactInfoForm;
import setup.DriverSetup;

import static enums.driverSetup.TestsSettingsEnum.NATIVES_PROPERTY;

public class ContactManagerTest {
    ContactAdditionForm contactAdditionForm;
    ContactInfoForm contactInfoForm;

    /**
     * uses to prepare AppiumDriver
     */
    @BeforeClass
    public void setup() {
        contactAdditionForm = new ContactAdditionForm();
        contactInfoForm = new ContactInfoForm();
        try {
            DriverSetup.prepareDriver(NATIVES_PROPERTY.text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * uses to close driver
     */
    @AfterClass
    public void tearDown() {
        DriverSetup.getDriver().quit();
    }

    /**
     * uses for checking some functional of ContactManager
     */
    @Test(description = "Native test of general functional of ContactManager", groups = "native")
    public void checkContactManager() {
        contactAdditionForm.checkAdditionalButton();

        contactInfoForm.checkNameForm();
        contactInfoForm.checkPhoneForm();
        contactInfoForm.checkEmailForm();
        contactInfoForm.checkSubmitButton();
    }
}
