package org.example.pages.elements;

import org.openqa.selenium.WebElement;

public abstract class AbstractElement {

    protected final WebElement element;
    protected AbstractElement(WebElement webElement) {
        this.element = webElement;
    }

    public String getText() {
        return element.getText();
    }

    public boolean isVisible() {
        return element.isDisplayed();
    }
    public String getAttribute(String attributeName) {
        return element.getAttribute(attributeName);
    }

    public boolean checkAttribute(String attributeName, String expectedValue) {
        String actualValue = getAttribute(attributeName);
        return actualValue.equals(expectedValue);
    }// добавил этот метод для того, чтобы в дальнейшем была возможность проверки работы кнопки Версия для слабовидящих

    public boolean checkCssAttribute(String cssAttributeName, String expectedValue) {
        String actualValue = getAttribute(cssAttributeName);
        return actualValue.equals(expectedValue);
    }// добавил этот метод для того, чтобы в дальнейшем была возможность проверки работы кнопки Версия для слабовидящих
}
