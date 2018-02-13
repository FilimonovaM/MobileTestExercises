package scenarios.natives;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.contact_manager.ContactAdditionForm;
import page_objects.contact_manager.ContactInfoForm;
import setup.SetupDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static enums.CommonInfoEnum.HOST_MASK;
import static enums.TestsSettingsEnum.NATIVES_PROPERTY;

public class ContactManagerTest extends SetupDriver {
    ContactAdditionForm contactAdditionForm;
    ContactInfoForm contactInfoForm;
    AppiumDriver driver;

    /**
     * uses to prepare AppiumDriver
     */
    @BeforeClass
    public void setup() {
        contactAdditionForm = new ContactAdditionForm();
        contactInfoForm = new ContactInfoForm();

        try {
            driver = new AppiumDriver(new URL(properties.getProperty(HOST_MASK.text)),
                    prepareDriverSettings(NATIVES_PROPERTY.text));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /**
     * uses for checking some functional of ContactManager
     */
    @Test(description = "Native test of some functional of ContactManager", groups = "native")
    public void checkContactManager() {
        contactAdditionForm.checkTheButton(driver);

        contactInfoForm.checkContactNameForm(driver);
        contactInfoForm.checkContactPhoneForm(driver);
    }
}
