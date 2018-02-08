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
        String appPackageName = "com.example.android.contactmanager:id/";

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Add Contact']")).click();

        driver.resetApp();
        driver.findElementByAccessibilityId("Add Contact").click();

        driver.resetApp();
        driver.findElement(By.id(appPackageName + "addContactButton")).click();

        System.out.println("Test status - 200OK!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
