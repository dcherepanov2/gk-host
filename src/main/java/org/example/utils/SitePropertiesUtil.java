package org.example.utils;

public class SitePropertiesUtil {
    private static final String nameProperties = "site.properties";

    public static String getProperty(String propertyName){
        return PropertyUtil.getPropertyByName(nameProperties, propertyName);
    }
}
