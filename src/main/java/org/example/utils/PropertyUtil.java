package org.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class PropertyUtil {

    private final static String pathToPropertyFiles = "src/main/resources";
    private PropertyUtil(){}

    public static String getPropertyByName(String filename, String propertyName) {
        try (FileInputStream fis = new FileInputStream(pathToPropertyFiles + "/" + filename)) {
            Properties property = new Properties();
            property.load(fis);
            return property.getProperty(propertyName);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while loading the property file.", e);//TODO: добавить более информативную ошибку
        }
    }
}
