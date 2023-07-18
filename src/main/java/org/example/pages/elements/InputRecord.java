package org.example.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InputRecord extends AbstractRecord {
    private final WebElement firstRecord;
    private WebElement secondRecord;
    public InputRecord(WebElement webElement) {
        super(webElement, By.cssSelector("div.ui-g-4 > p"), By.className("ui-g-2"));
        List<WebElement> recordsInput = webElement.findElements(By.cssSelector(".twoIntegerBlock input, textarea, input"));
        firstRecord = recordsInput.get(0);
        if(recordsInput.size() > 1)
            secondRecord = recordsInput.get(1);
    }

    public WebElement getFirstRecord() {
        return firstRecord;
    }

    public WebElement getSecondRecord() {
        return secondRecord;
    }

    void setFirstRecordValue(String value){
        firstRecord.sendKeys(value);
    }

    void setSecondRecord(String value){
        secondRecord.sendKeys(value);
    }
}