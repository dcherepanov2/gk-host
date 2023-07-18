package org.example.pages;

import org.example.pages.personal.area.section.other.OtherSection;
import org.example.utils.SitePropertiesUtil;
import org.openqa.selenium.WebDriver;
public class PersonalAreaPage extends AbstractPage {

    private final String uri = SitePropertiesUtil.getProperty("uri.account");

    private OtherSection otherSection;

    private final WebDriver driver;

    public PersonalAreaPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public PersonalAreaPage getPage(){
        driver.get(super.getHost() + uri);
        return this;
    }
    public OtherSection getOtherSection(){
        otherSection = new OtherSection(driver);
        otherSection.getPage();
        return otherSection;
    }
}
