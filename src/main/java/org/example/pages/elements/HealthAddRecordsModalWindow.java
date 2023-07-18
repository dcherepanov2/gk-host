package org.example.pages.elements;

import org.openqa.selenium.WebElement;
import java.time.Month;
import java.util.List;
public class HealthAddRecordsModalWindow implements DateChangeableModal {
    private final WebElement buttonOpenModalWindow;
    private final WebElement saveButtonWebElement;
    private WebElement closeButton;
    private final InputRecords records;
    private final CalendarHandler calendarHandler;
    public HealthAddRecordsModalWindow(WebElement buttonOpenModalWindow, WebElement saveButtonWebElement, List<WebElement> inputRecords, WebElement calendarWebElement) {
        this.buttonOpenModalWindow = buttonOpenModalWindow;
        this.saveButtonWebElement = saveButtonWebElement;
        this.records = new InputRecords(inputRecords);
        this.calendarHandler = new CalendarHandler(calendarWebElement);
    }

    @Override
    public HealthAddRecordsModalWindow click() {
        buttonOpenModalWindow.click();
        return this;
    }
    @Override
    public HealthAddRecordsModalWindow setDate(int day, Month month, int year){
        calendarHandler.setDate(day, month, year);
        return this;
    }
    @Override
    public HealthAddRecordsModalWindow setDate(int day, Month month, int year, int hours, int minutes){
        calendarHandler.setDate(day, month, year, hours, minutes);
        return this;
    }

    public InputRecords getRecordsInputField() {
        return records;
    }
    public void saveNewRecords(){
        saveButtonWebElement.click();
    }

    public void setCloseButton(WebElement closeButton) {
        this.closeButton = closeButton;
    }

    @Override
    public void close() {
        closeButton.click();
    }
}
