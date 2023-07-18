package org.example.tests.personal_area.health.indicators;

import io.qameta.allure.Description;
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
import org.testng.annotations.*;
import org.testng.annotations.Test;

@Feature("Личный кабинет -> Разное -> Показатели здоровья")
@Link(name = "Тестирование возможности создания новых записей")
public class HealthIndicatorsSectionCreation {
    private WebDriver driver;
    private MainPage mainPage;
    private HealthIndicatorsSection healthIndicatorsSection;
    private final String temperatureValue = String.valueOf(RandomUtils.generateRoundedRandomFloat(1));
    private final String pressureValue1 = String.valueOf(RandomUtils.generateRandomInteger());
    private final String pressureValue2 = String.valueOf(RandomUtils.generateRoundedRandomInteger(Integer.parseInt(pressureValue1) - 1));
    private final String weightValue = String.valueOf(RandomUtils.generateRandomInteger());
    private final String pulseValue = String.valueOf(RandomUtils.generateRandomInteger());
    private final String moodValue = RandomUtils.generateRandomString("Нормальное");
    private final String generalHealthValue = RandomUtils.generateRandomString("Нормальное");

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
        healthIndicatorsSection.getPage();
    }

    @Test(dependsOnMethods = "getRecordsInputField", description = "Внесение случайных значений в поля температура и давление, сохранение записей")
    public void writeTempAndPressureInInputRecords(){
        HealthAddRecordsModalWindow healthAddRecordsModalWindow = healthIndicatorsSection.getHealthAddRecordsModalWindow();
        InputRecords recordsInputField = healthAddRecordsModalWindow.getRecordsInputField();
        healthIndicatorsSection.elementIsDisplayedByTextContainsAndWait("Новая запись состояния здоровья", 2L);

        recordsInputField.findRecordFieldByNameAndSetValue(HealthMetric.TEMPERATURE, temperatureValue);
        recordsInputField.findRecordFieldByNameAndSetValue(HealthMetric.PRESSURE, pressureValue1, pressureValue2);

        healthAddRecordsModalWindow.saveNewRecords();

        healthIndicatorsSection.elementIsDisplayedByTextContainsAndWait(temperatureValue, 2L)
                               .elementIsDisplayedByTextContainsAndWait(pressureValue1, 2L)
                               .elementIsDisplayedByTextContainsAndWait(pressureValue2, 2L);
    }

    @Test(dependsOnMethods = "getRecordsInputField", description = "Внесение случайных значений в поля пульс и настроение, сохранение записей")
    public void moodAndPulseInInputRecords(){
        HealthAddRecordsModalWindow healthAddRecordsModalWindow = healthIndicatorsSection.getHealthAddRecordsModalWindow();
        InputRecords recordsInputField = healthAddRecordsModalWindow.getRecordsInputField();
        healthIndicatorsSection.elementIsDisplayedByTextContainsAndWait("Новая запись состояния здоровья", 2L);

        recordsInputField.findRecordFieldByNameAndSetValue(HealthMetric.MOOD, moodValue);
        recordsInputField.findRecordFieldByNameAndSetValue(HealthMetric.PULSE, pulseValue);

        healthAddRecordsModalWindow.saveNewRecords();

        healthIndicatorsSection.elementIsDisplayedByTextContainsAndWait(moodValue, 2L)
                .elementIsDisplayedByTextContainsAndWait(pulseValue, 2L);
    }


    @Test(dependsOnMethods = "getRecordsInputField", description = "Внесение случайных значений в поля вес и общее состояние здоровья, сохранение записей")
    public void weightAndSugarBloodInInputRecords(){
        HealthAddRecordsModalWindow healthAddRecordsModalWindow = healthIndicatorsSection.getHealthAddRecordsModalWindow();
        InputRecords recordsInputField = healthAddRecordsModalWindow.getRecordsInputField();
        healthIndicatorsSection.elementIsDisplayedByTextContainsAndWait("Новая запись состояния здоровья", 2L);

        recordsInputField.findRecordFieldByNameAndSetValue(HealthMetric.WEIGHT, weightValue);
        recordsInputField.findRecordFieldByNameAndSetValue(HealthMetric.GENERAL_HEALTH, generalHealthValue);

        healthAddRecordsModalWindow.saveNewRecords();

        healthIndicatorsSection.elementIsDisplayedByTextContainsAndWait(weightValue, 2L)
                .elementIsDisplayedByTextContainsAndWait(generalHealthValue, 2L);
    }

    @AfterTest(description = "Закрытие браузера")
    public void closeDriver(){
        driver.quit();
    }
}
