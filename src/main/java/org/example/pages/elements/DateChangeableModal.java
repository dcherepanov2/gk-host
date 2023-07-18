package org.example.pages.elements;

import java.time.Month;

public interface DateChangeableModal extends ModalWindow{// реализовать ModalWindow, который будет иметь close и open
    Object setDate(int day, Month month, int year);

    Object setDate(int day, Month month, int year, int hours, int minutes);
}
