package ru.yandex.market.ui.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class YandexMarketSearchResults extends YandexMarketBasePage{
    private String titleSelector = "//title";

    public SelenideElement getTitle() {
        return $(By.xpath(titleSelector));
    }
}
