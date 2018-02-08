package scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest extends DriverSetup {

    @BeforeClass
    public void setup() {
        prepareAndroidNative();
    }

    /**
     * uses for checking the access to the button by the different types of locators
     */
    @Test
    public void checkButton() {
        String appPackageName = "com.example.android.contactmanager:id/";

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Add Contact']")).click();

        driver.resetApp();
        driver.findElementByAccessibilityId("Add Contact").click();

        driver.resetApp();
        driver.findElementById(appPackageName + "addContactButton").click();

        System.out.println("Test status - 200 OK!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
