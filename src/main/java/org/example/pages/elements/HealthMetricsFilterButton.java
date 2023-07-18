package org.example.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HealthMetricsFilterButton extends AbstractElement implements ClickableElement, Filter<HealthMetric>{

    private List<WebElement> healthsMetrics;

    public HealthMetricsFilterButton(WebElement element) {
        super(element);
    }

    @Override
    public HealthMetricsFilterButton click() {
        element.click();
        healthsMetrics = element.findElements(By.cssSelector("div.ui-dropdown-items-wrapper.ng-tns-c69-9 ul li.ui-dropdown-item"));
        return this;
    }

    @Override
    public HealthMetricsFilterButton selectFilter(HealthMetric filter) {
        WebElement searchElement = healthsMetrics.stream()
                .filter(e -> e.getAttribute("aria-label").equals(filter.getName()))
                .findFirst().orElseThrow();
        searchElement.click();
        return this;
    }
}
