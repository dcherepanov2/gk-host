package org.example.pages;

import java.time.Month;

public interface DateCheckablePage {
    void checkRecordWithDate(int day, Month month, int year, int hours, int minutes);

    void checkRecordWithDate(int day, Month month, int year);
}
