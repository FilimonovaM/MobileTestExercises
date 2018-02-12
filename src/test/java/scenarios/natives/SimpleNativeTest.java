package scenarios.natives;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.DriverSetup;

public class SimpleNativeTest extends DriverSetup {

//    @BeforeClass
//    public void setup() {
//        prepareAndroidNative();
//    }

    /**
     * uses for checking the access to the button by the different types of locators
     */
    @Test(description = "some description")
    public void checkButton() {
//        String appPackageName = "com.example.android.contactmanager:id/";
//
//        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Add Contact']")).click();
//
//        driver.resetApp();
//        driver.findElementByAccessibilityId("Add Contact").click();
//
//        driver.resetApp();
//        driver.findElementById(appPackageName + "addContactButton").click();
//
//        System.out.println("Test status - 200 OK!");
    }

    @Test(description = "some description")
    public void checkURL() {

    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}
