package scenarios.natives;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.contact_manager.ContactAdditionForm;
import page_objects.contact_manager.ContactInfoForm;

import static enums.driverSetup.TestsSettingsEnum.NATIVES_PROPERTY_ON_FARM;
import static setup.DriverSetup.getDriver;
import static setup.DriverSetup.prepareDriver;

public class ContactManagerTest {
    ContactAdditionForm contactAdditionForm;
    ContactInfoForm contactInfoForm;

    /**
     * uses to prepare AppiumDriver
     */
    @BeforeClass(alwaysRun = true)
    public void setup() {
        contactAdditionForm = new ContactAdditionForm();
        contactInfoForm = new ContactInfoForm();
        try {
            prepareDriver(NATIVES_PROPERTY_ON_FARM.text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * uses to close driver
     */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getDriver().closeApp();
        System.out.println("Driver closes application");
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
