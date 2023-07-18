package org.example.tests.personal_area.health.indicators;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.example.factory.DriverFactory;
import org.example.pages.MainPage;
import org.example.pages.elements.HealthMetricsFilterButton;
import org.example.pages.personal.area.section.other.health.indecators.HealthIndicatorsSection;
import org.example.pages.elements.HealthMetric;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Arrays;

@Feature("Личный кабинет -> Разное -> Показатели здоровья")
@Link(name = "Тестирование возможности создания новых записей", url = "*ссылка на набор тест-кейсов*")
public class FilterHealthIndicators {//
    private WebDriver driver;
    private MainPage mainPage;
    private HealthIndicatorsSection healthIndicatorsSection;

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

    @Test(dependsOnMethods = "auth", description = "Открытие вкладки Личный кабинет -> Разное -> Показатели здоровья")
    public void openHealthIndicatorsSection(){
        healthIndicatorsSection = new HealthIndicatorsSection(driver);
        healthIndicatorsSection.getPage();
    }

    @Test(dependsOnMethods = "openHealthIndicatorsSection", description = "Выбор фильтра 'Уровень сахара в крови', проверка, что записи остальных типов при этом не отображаются ")
    public void selectSugarBloodFilter(){
        HealthMetricsFilterButton healthMetricsFilter = healthIndicatorsSection.getHealthMetricsFilter();
        healthMetricsFilter.selectFilter(HealthMetric.SUGAR_BLOOD);

        healthIndicatorsSection.elementIsDisplayedByTextContains(HealthMetric.SUGAR_BLOOD.getName());
        Arrays.stream(HealthMetric.values()).filter(x -> !x.equals(HealthMetric.SUGAR_BLOOD))
                                            .forEach(x -> healthIndicatorsSection.elementIsNotDisplayedByTextAndWait(x.getName(), "div", 2L));
    }

    @Test(dependsOnMethods = "openHealthIndicatorsSection", description = "Выбор фильтра 'Давление', проверка, что записи остальных типов при этом не отображаются ")
    public void selectPressureFilter(){
        HealthMetricsFilterButton healthMetricsFilter = healthIndicatorsSection.getHealthMetricsFilter();
        healthMetricsFilter.selectFilter(HealthMetric.PRESSURE);

        healthIndicatorsSection.elementIsDisplayedByTextContains(HealthMetric.PRESSURE.getName());
        Arrays.stream(HealthMetric.values()).filter(x -> !x.equals(HealthMetric.PRESSURE))
                .forEach(x -> healthIndicatorsSection.elementIsNotDisplayedByTextAndWait(x.getName(), "div", 2L));
    }

    @Test(dependsOnMethods = "openHealthIndicatorsSection", description = "Выбор фильтра 'Алкоголь в крови', проверка, что записи остальных типов при этом не отображаются ")
    public void selectAlcoholInBloodFilter(){
        healthIndicatorsSection.getHealthMetricsFilter()
                .selectFilter(HealthMetric.ALCOHOL_IN_BLOOD);

        healthIndicatorsSection.elementIsDisplayedByTextContains(HealthMetric.ALCOHOL_IN_BLOOD.getName());
        Arrays.stream(HealthMetric.values()).filter(x -> !x.equals(HealthMetric.ALCOHOL_IN_BLOOD))
                .forEach(x -> healthIndicatorsSection.elementIsNotDisplayedByTextAndWait(x.getName(), "div", 2L));
    }


    @Test(dependsOnMethods = "openHealthIndicatorsSection", description = "Выбор фильтра 'Температура', проверка, что записи остальных типов при этом не отображаются ")
    public void selectTemperatureFilter(){
        healthIndicatorsSection.getHealthMetricsFilter()
                .selectFilter(HealthMetric.TEMPERATURE);

        healthIndicatorsSection.elementIsDisplayedByTextContains(HealthMetric.TEMPERATURE.getName());
        Arrays.stream(HealthMetric.values()).filter(x -> !x.equals(HealthMetric.TEMPERATURE))
                .forEach(x -> healthIndicatorsSection.elementIsNotDisplayedByTextAndWait(x.getName(), "div", 2L));
    }

    @AfterTest
    @Description("Закрытие браузера")
    public void closeDriver(){
        driver.quit();
    }
}
