package org.example.pages.personal.area.section.other.health.indecators;

import org.example.pages.DateCheckablePage;
import org.example.pages.AbstractPage;
import org.example.pages.elements.HealthAddRecordsModalWindow;
import org.example.pages.elements.HealthMetricsFilterButton;
import org.example.pages.elements.SettingsModalWindow;
import org.example.utils.SitePropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HealthIndicatorsSection extends AbstractPage implements DateCheckablePage {
    private final WebDriver driver;
    private final String uri = SitePropertiesUtil.getProperty("uri.account.card.health");

    public HealthIndicatorsSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @Override
    public HealthIndicatorsSection getPage(){
        driver.get(super.getHost() + uri);
        return this;
    }
    public HealthAddRecordsModalWindow getHealthAddRecordsModalWindow(){
        By modalWindowSelector = By.cssSelector("a.button.bordered.lower.rel.action-button");
        By saveButtonSelector = By.cssSelector("button[type='submit'].dark.btn-shadow");
        By recordsSelector = By.cssSelector("div.ui-g.ng-star-inserted");
        By calendarSelector = By.cssSelector("input[type='text'].create-date.ui-inputtext");
        By closeButtonSelector = By.cssSelector("a.ui-dialog-titlebar-close");
        WebElement healthAddRecordsModalWindow = driver.findElement(modalWindowSelector);
        healthAddRecordsModalWindow.click();
        WebElement saveButtonWebElement = driver.findElement(saveButtonSelector);
        List<WebElement> records = driver.findElements(recordsSelector);
        WebElement calendarWebElement = driver.findElement(calendarSelector);
        HealthAddRecordsModalWindow healthAddRecords = new HealthAddRecordsModalWindow(healthAddRecordsModalWindow,
                saveButtonWebElement,
                records,
                calendarWebElement);
        WebElement closeButton = driver.findElement(closeButtonSelector);
        healthAddRecords.setCloseButton(closeButton);
        return healthAddRecords;
    }
    public SettingsModalWindow getSettingsButton(){
        By settingSelector = By.cssSelector("a.button[tabindex='0']");
        By closeSelector = By.cssSelector("a.ui-dialog-titlebar-close");
        WebElement webElement = driver.findElement(settingSelector);
        SettingsModalWindow settingsModalWindow = new SettingsModalWindow(webElement);
        WebElement closeButton = driver.findElement(closeSelector);
        settingsModalWindow.click();
        settingsModalWindow.setClose(closeButton);
        return settingsModalWindow;
    }
    @Override
    public void checkRecordWithDate(int day, Month month, int year, int hours, int minutes) {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hours, minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        super.elementIsDisplayedByTextContains(dateTime.format(formatter));
    }
    @Override
    public void checkRecordWithDate(int day, Month month, int year) {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");// вынести патерн в настройки приложения, т.к.
        super.elementIsDisplayedByTextContains(dateTime.format(formatter));
    }
    public HealthMetricsFilterButton getHealthMetricsFilter(){//TODO: Вынести в класс SavedHealthRecord
        By filterSelector = By.cssSelector("div.dropdown.ui-dropdown");
        WebElement element = driver.findElement(filterSelector);
        HealthMetricsFilterButton button = new HealthMetricsFilterButton(element);
        button.click();
        return button;
    }
}
