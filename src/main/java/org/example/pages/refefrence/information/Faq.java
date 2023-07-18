package org.example.pages.refefrence.information;

import org.example.pages.AbstractPage;
import org.example.utils.SitePropertiesUtil;
import org.openqa.selenium.WebDriver;

class Faq extends AbstractPage { // код не реализовал пока что, т.к. задание было просто создать архитектуру

    private final String uri = SitePropertiesUtil.getProperty("uri.reference.information.faq");

    Faq(WebDriver driver) {
        super(driver);
    }

    @Override
    public Faq getPage() {
        WebDriver driver = getDriver();
        String host = getHost();
        driver.get(host + uri);
        return this;
    }
}
