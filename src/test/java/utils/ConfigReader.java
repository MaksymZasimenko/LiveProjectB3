package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String getProperty(String key){
        String propertyPath = "configurations.properties";

        try(FileInputStream fileInputStream = new FileInputStream(propertyPath)){
            Properties properties = new Properties();
            properties.load(fileInputStream);

            return properties.getProperty(key);
        }catch (IOException e){
            e.printStackTrace();
        }

        throw new RuntimeException("Error reading properties");
    }
}
