package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    protected AndroidDriver driver;

    /**
     * uses for preparing driver and to set the general settings.
     */
    public void prepareAndroidNative() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");

        //// Samsung GT-I9100 (Android 4.1.2)
        //      desiredCapabilities.setCapability("deviceName", "0019b3ef0cfd5e");

        //// Samsung GT-N7100 (Android 4.4.4)
        //      desiredCapabilities.setCapability("deviceName", "4df1123b5cac8f87");

        //Samsung SM-N9005 (Android 6.0)
        desiredCapabilities.setCapability("deviceName", "3394b869");

        File appDir = new File("src/main/resources");
        File app = new File(appDir, "contactmanager.apk");
        desiredCapabilities.setCapability("app", app.getAbsolutePath());

        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
