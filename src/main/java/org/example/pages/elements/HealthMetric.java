package org.example.pages.elements;

public enum HealthMetric {
    TEMPERATURE("Температура", "°С"),
    WEIGHT("Вес", "кг"),
    PRESSURE("Давление",""),
    SUGAR_BLOOD("Уровень сахара в крови","ммоль/л") ,
    PULSE("Пульс", "уд./мин."),
    MOOD("Настроение", ""),
    ALCOHOL_IN_BLOOD("Алкоголь в крови", "промиль"),
    AMBIVALENCE("Амбивалентность", "%"),
    GENERAL_HEALTH("Общее состояние здоровья",""),
    CONDITION_OF_THE_SKIN("Cостояние кожных покровов", "");
    private final String name;

    private final String unit;
    HealthMetric(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
}
