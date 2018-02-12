package utile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    Properties currentProp = new Properties();

    Properties getCurrentProp() throws IOException {
        FileInputStream in = new FileInputStream(System.getProperty("user.dir") +
                "/properties_native/native_test.properties");
        currentProp.load(in);
        in.close();
        return currentProp;
    }

    protected String getProp(String key) throws IOException {
        if (!currentProp.contains(key)) {
            getCurrentProp();
        }
        return currentProp.getProperty(key);
    }
}