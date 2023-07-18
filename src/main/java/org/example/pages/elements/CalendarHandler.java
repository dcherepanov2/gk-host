package org.example.pages.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
public class CalendarHandler extends AbstractElement {// если время останется написать еще фильтры записей,
                                                            // который будет наследовать от AbstractElement, в свою очередь
                                                            // от фильтра будет наследоваться этот класс
                                                            // так как тоже должен иметь возможность устанавливать конкретную дату при нажатии на определенную кнопку
    public CalendarHandler(WebElement element) {
        super(element);
    }

    private String formatDate(int day, Month month, int year, int hours, int minutes) {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hours, minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return dateTime.format(formatter);
    }

    public void setDate(int day, Month month, int year) {
        element.click();
        String formattedDate = formatDate(day, month, year, 0, 0);
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));// выбрал эту команду, так как стандартный clear не срабатывал
        element.sendKeys(formattedDate);
    }

    public void setDate(int day, Month month, int year, int hours, int minutes) {
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        String formattedDate = formatDate(day, month, year, hours, minutes);
        element.sendKeys(formattedDate);
    }
}
