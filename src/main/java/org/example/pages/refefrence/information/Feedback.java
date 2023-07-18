package org.example.pages.refefrence.information;

import org.example.pages.AbstractPage;
import org.example.utils.SitePropertiesUtil;
import org.openqa.selenium.WebDriver;

public class Feedback extends AbstractPage { // код не реализовал пока что, т.к. задание было просто создать архитектуру

    private final WebDriver driver;
    private final String uri = SitePropertiesUtil.getProperty("uri.reference.information.feedback");

    public Feedback(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public Feedback getPage() {
        String host = getHost();
        driver.get(host + uri);
        return this;
    }
}
