package ru.yandex.market.ui.pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexMarketSearchResults {
    private String logoYandexMarketSelector = "//div[@class = \"_7v6Uf-UYpr _2AL_nfH3zl\"]";
    private String searchFieldSelector = "//input[@id= \"header-search\"]";
    private String seacrhButtonSelector = "//button[@class = \"_1XiEJDPVpk\"]";
    private String headerButtonsSelector = "//div[@class = \"JdoDRPz419\"]/div/div/..";
    private String titleSelector = "//title";

    public ElementsCollection getHeaderButtons() {
        return $$(By.xpath(headerButtonsSelector));
    }

    public SelenideElement getLogoYandexMarketButton() {
        return $(By.xpath(logoYandexMarketSelector));
    }

    public SelenideElement getSearchField() {
        return $(By.xpath(searchFieldSelector));
    }

    public SelenideElement getSearchButton() {
        return $(By.xpath(seacrhButtonSelector));
    }

    public SelenideElement getTitle() {
        return $(By.xpath(titleSelector));
    }
}
