package org.example.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractRecord extends AbstractElement {
    private final WebElement name;
    private WebElement unit;

    protected AbstractRecord(WebElement webElement, By nameSelector, By unitSelector) {
        super(webElement);
        name = webElement.findElement(nameSelector);
        List<WebElement> unit =  webElement.findElements(unitSelector);
        if(!unit.isEmpty())
            this.unit = unit.get(0);
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getUnit() {
        return unit;
    }


}
