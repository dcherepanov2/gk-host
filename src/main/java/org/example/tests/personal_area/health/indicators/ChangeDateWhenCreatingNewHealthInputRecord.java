package org.example.tests.personal_area.health.indicators;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import org.example.factory.DriverFactory;
import org.example.pages.MainPage;
import org.example.pages.personal.area.section.other.health.indecators.HealthIndicatorsSection;
import org.example.pages.elements.HealthAddRecordsModalWindow;
import org.example.pages.elements.HealthMetric;
import org.example.pages.elements.InputRecords;
import org.example.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Feature("Личный кабинет -> Разное -> Показатели здоровья")
@Link(name = "Тестирование возможностей создания новых записей")
public class ChangeDateWhenCreatingNewHealthInputRecord {
    // подрузумивается что тест будет работать на чистой базе, так как запись с датой, которую мы вносим уже может существовать на странице
    private WebDriver driver;
    private MainPage mainPage;
    private HealthAddRecordsModalWindow healthAddIndicatorsButton;
    private InputRecords inputRecords;
    private HealthIndicatorsSection healthIndicatorsSection;
    private final int day = LocalDate.now().getDayOfMonth();
    private final Month month = LocalDate.now().getMonth();
    private final String temperature = String.valueOf(RandomUtils.generateRoundedRandomFloat(1));
    private final int year = LocalDateTime.now().getYear();

    @Parameters("browser")
    @BeforeTest(description = "Инициализация драйвера и их конфигурация для правильной работы тестов")
    void setUp(String browser) {
        driver = DriverFactory.createDriver(browser);
        mainPage = new MainPage(driver);
    }

    @Test(description = "Авторизация в личном кабинете")
    public void auth() {
        mainPage.getPage().getHeader().login();
    }

    @Test(dependsOnMethods = "auth", description = "Открытие модульного окна с полями ввода о состоянии здоровья пациента")
    public void getRecordsInputField(){
        healthIndicatorsSection = new HealthIndicatorsSection(driver);
        healthAddIndicatorsButton = healthIndicatorsSection.getPage().getHealthAddRecordsModalWindow();
        inputRecords = healthAddIndicatorsButton.getRecordsInputField();
        healthIndicatorsSection.elementIsDisplayedByTextContains("Новая запись состояния здоровья");
    }

    @Test(dependsOnMethods = "getRecordsInputField",description = "Установка даты и внесение записи для проверки возможности изменения даты при сохранении новой записи")
    public void setDateAndVerify(){
        healthAddIndicatorsButton.setDate(day, month, year, 11, 58);
        inputRecords.findRecordFieldByNameAndSetValue(HealthMetric.TEMPERATURE, temperature);
        healthAddIndicatorsButton.saveNewRecords();
        healthIndicatorsSection.checkRecordWithDate(day, month, year, 11, 58);
    }


    @AfterTest(description = "Закрытие браузера")
    public void closeDriver(){
        driver.quit();
    }
}
