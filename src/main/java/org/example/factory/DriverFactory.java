package org.example.factory;

import org.example.utils.SitePropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class DriverFactory {
    private static WebDriver driver;
    private DriverFactory(){}

    //знаю, что существует WebDriverManager, который упрощает инииализацию driver,
    // но так как в задании не была указана эта зависимость, то решил воспользоваться своим решением
    public static WebDriver createDriver(String browser){
        switch (browser) {
            case "chrome" -> {
                String driverPropertyName = SitePropertiesUtil.getProperty("chrome.driver.property");
                String driverPath = SitePropertiesUtil.getProperty("chrome.driver.path");
                System.setProperty(driverPropertyName, driverPath);
                driver = new ChromeDriver();
            }
            default ->
                    throw new IllegalArgumentException("В текущей версии автотестов браузер" + browser + "не поддерживается");
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
