package utile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    static public Properties getCurrentProp(String fileName){
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+fileName)){
            properties.load(inputStream);
        }catch (IOException e) {
            properties = null;
            e.printStackTrace();
        }
        return properties;
    }
}
