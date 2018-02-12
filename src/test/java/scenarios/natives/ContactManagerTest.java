package scenarios.natives;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.contact_manager.ContactInfoForm;
import page_objects.contact_manager.ContactAdditionForm;
import setup.SetupDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static enums.TestsSettingsEnum.APPIUM_LOCALHOST;
import static enums.TestsSettingsEnum.NATIVES_PROPERTY;

public class ContactManagerTest extends SetupDriver {
    ContactAdditionForm contactAdditionForm;
    ContactInfoForm contactInfoForm;
    AppiumDriver driver;

    @BeforeClass
    public void setup() {
        contactAdditionForm = new ContactAdditionForm();
        contactInfoForm = new ContactInfoForm();
        try {
            driver = new AppiumDriver(new URL(APPIUM_LOCALHOST.text), prepareDriver(NATIVES_PROPERTY.text));
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

    @Test
    public void checkContactManager() {

        contactAdditionForm.checkTheButton(driver);

        contactInfoForm.checkContactNameForm(driver);
        contactInfoForm.checkContactPhoneForm(driver);
    }
}
