package org.example.pages;
import org.example.utils.SitePropertiesUtil;
import org.openqa.selenium.WebDriver;
public abstract class AbstractPage extends AbstractPageChecker {
    private final Header header;
    private final Footer footer;

    private final WebDriver driver;
    String host = SitePropertiesUtil.getProperty("host");

    protected AbstractPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.header = new Header(driver);
        this.footer = new Footer(driver);
    }

    public Header getHeader() {
        return header;
    }
    public Footer getFooter() {
        return footer;
    }
    protected String getHost(){
        return host;
    }
    public abstract Object getPage();

    protected WebDriver getDriver(){
        return driver;
    }
}
