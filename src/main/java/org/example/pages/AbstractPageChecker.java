package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public abstract class AbstractPageChecker {
    private final WebDriver driver;

    protected AbstractPageChecker(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractPageChecker elementIsDisplayedByTextContains(String text) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]/.."));
        assertTrue(element.isDisplayed());
        return this;
    }
    public AbstractPageChecker elementIsDisplayedByTextContainsAndWait(String text, Long second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        By xpathSelector = By.xpath("//*[contains(text(), '" + text + "')]/..");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpathSelector));
        assertTrue(element.isDisplayed());
        return this;
    }

    public AbstractPageChecker elementIsNotDisplayedByTextContainsAndWait(String text, Long second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        By xpathSelector = By.xpath("//*[contains(text(), '" + text + "')]/..");
        Boolean checkInvisibilityElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSelector));
        assertTrue(checkInvisibilityElement);
        return this;
    }

    public AbstractPageChecker elementIsNotDisplayedByTextContainsAndWait(String text, String attribute, Long second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        By xpathSelector = By.xpath("//" + attribute + "[contains(text(), '" + text + "')]/..");
        Boolean checkInvisibilityElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSelector));
        assertTrue(checkInvisibilityElement);
        return this;
    }

    public AbstractPageChecker elementIsNotDisplayedByTextAndWait(String text, String attribute, Long second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        By xpathSelector = By.xpath("//" + attribute + "[normalize-space(string()) = '" + text + "']");
        Boolean checkInvisibilityElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathSelector));
        assertTrue(checkInvisibilityElement);
        return this;
    }

    public AbstractPageChecker elementIsNotDisplayedByText(String text, String attribute) {
        List<WebElement> elements = driver.findElements(By.xpath("//" + attribute + "[normalize-space(string()) = '" + text + "']"));
        assertTrue(elements.isEmpty());
        return this;
    }

    public AbstractPageChecker elementIsNotDisplayedByTextContains(String text) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]/.."));
        assertTrue(elements.isEmpty());
        return this;
    }

    public AbstractPageChecker elementIsDisplayedById(String id) {
        WebElement element = driver.findElement(By.id(id));
        assertTrue(element.isDisplayed());
        return this;
    }// не нашел применения для тестирования вкладки /account/card/health, но так как задание было заложить архитектуру в том числе - решил оставить

}
