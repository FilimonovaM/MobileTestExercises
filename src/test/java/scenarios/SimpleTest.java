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

    @Test
    public void checkButton() {

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Add Contact']")).click();

        driver.resetApp();
        driver.findElementByAccessibilityId("Add Contact").click();

//        driver.resetApp();
//        String appPackageName = "com.example.android.contactmanager:id/";
//        driver.findElementById(appPackageName + "addContactButton").click();

        System.out.println("Test status - 200 OK!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
