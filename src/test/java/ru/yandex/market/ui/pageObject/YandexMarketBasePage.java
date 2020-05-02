package ru.yandex.market.ui.pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexMarketBasePage {
    private String headerCategoriesButtonsSelector = "//div[@class = \"_381y5orjSo _21NjfY1k45\"]/div";
    private String logoYandexMarketSelector = "//div[@class = \"_7v6Uf-UYpr _2AL_nfH3zl\"]";
    private String searchFieldSelector = "//input[@id= \"header-search\"]";
    private String searchButtonSelector = "//button[@class = \"_1XiEJDPVpk\"]";
    private String headerButtonsSelector = "//div[@class = \"JdoDRPz419\"]/div/div/..";

    public ElementsCollection getHeaderButtons() {
        return $$(By.xpath(headerButtonsSelector));
    }

    public ElementsCollection getHeaderCategoriesButtons() { return $$(By.xpath(headerCategoriesButtonsSelector)); }

    public SelenideElement getLogoYandexMarketButton() {
        return $(By.xpath(logoYandexMarketSelector));
    }

    public SelenideElement getSearchField() {
        return $(By.xpath(searchFieldSelector));
    }

    public SelenideElement getSearchButton() {
        return $(By.xpath(searchButtonSelector));
    }
}
