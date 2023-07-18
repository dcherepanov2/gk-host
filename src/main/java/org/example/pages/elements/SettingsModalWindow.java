package org.example.pages.elements;

import org.openqa.selenium.WebElement;

public class SettingsModalWindow implements ModalWindow {

    private final WebElement element;

    private WebElement close;

    public SettingsModalWindow(WebElement element) {
        this.element = element;
    }

    @Override
    public SettingsModalWindow click() {
        element.click();
        return this;
    }

    public void setClose(WebElement close) {
        this.close = close;
    }

    @Override
    public void close() {

    }
}
