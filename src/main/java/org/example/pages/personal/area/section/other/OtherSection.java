package org.example.pages.personal.area.section.other;

import org.example.pages.AbstractPage;
import org.example.pages.personal.area.section.other.health.indecators.HealthIndicatorsSection;
import org.example.utils.SitePropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class OtherSection extends AbstractPage {
    private final WebDriver driver;
    private HealthIndicatorsSection healthIndicatorsSection;
    private final String uri = SitePropertiesUtil.getProperty("uri.account.card");
    public OtherSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public OtherSection getPage() {
        driver.get(super.getHost() + uri);
        return this;
    }

    public HealthIndicatorsSection getHealthIndicators(){
        healthIndicatorsSection = new HealthIndicatorsSection(driver);
        healthIndicatorsSection.getPage();
        return healthIndicatorsSection;
    }
}
