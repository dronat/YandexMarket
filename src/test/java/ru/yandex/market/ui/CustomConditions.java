package ru.yandex.market.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import org.openqa.selenium.WebElement;

public class CustomConditions {
    public static Condition valueInAttribute(String attributeName, String value) {
        return new Condition(String.format("value '%s' in attribute '%s'", value, attributeName)) {
            @Override
            public boolean apply(Driver driver, WebElement element) {
                return element.getAttribute(attributeName).contains(value);
            }
        };
    }
}
