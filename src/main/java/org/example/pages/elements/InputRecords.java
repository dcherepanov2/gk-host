package org.example.pages.elements;

import org.example.exception.MissingSecondRecordException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputRecords {

    private final Map<String, InputRecord> records;

    public InputRecords(List<WebElement> records) {
        this.records = records.stream()
                .collect(Collectors.toMap(key -> new InputRecord(key).getName().getText(), InputRecord::new));
    }
    public InputRecord findRecordFieldByNameAndSetValue(HealthMetric healthMetric, String value){
        InputRecord inputRecordLocal = records.get(healthMetric.getName());
        inputRecordLocal.setFirstRecordValue(value);
        return inputRecordLocal;
    }

    public InputRecord findRecordFieldByNameAndSetValue(HealthMetric healthMetric, String valueInFirstInput, String valueInSecondInput){
        InputRecord inputRecordLocal = records.get(healthMetric.getName());
        if(inputRecordLocal.getSecondRecord() == null)
            throw new MissingSecondRecordException("У выбранной вами записи нету второго поля. Проверьте входные данные на странице еще раз.");
        inputRecordLocal.setFirstRecordValue(valueInFirstInput);
        inputRecordLocal.setSecondRecord(valueInSecondInput);
        return inputRecordLocal;
    }
}
