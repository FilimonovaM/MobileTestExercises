package scenarios.natives;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.ContactInfoForm;
import page_objects.ContactAdditionForm;
import setup.SetupDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ContactManagerTest extends SetupDriver {
    ContactAdditionForm contactAdditionForm;
    ContactInfoForm contactInfoForm;
    final String PROPERTIES = "/properties_native/native_test.properties";
    AndroidDriver driver;

    @BeforeClass
    public void setup() {
        contactAdditionForm = new ContactAdditionForm();
        contactInfoForm = new ContactInfoForm();
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), prepareDriver(PROPERTIES));
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
