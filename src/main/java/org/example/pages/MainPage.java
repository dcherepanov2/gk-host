package org.example.pages;

import org.example.utils.SitePropertiesUtil;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    private final WebDriver driver;

    private final String uri = SitePropertiesUtil.getProperty("uri.home");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public MainPage getPage() {
        driver.get(getHost() + uri);
        return this;
    }
}
