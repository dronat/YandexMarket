package ru.yandex.market.ui.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class YandexMarketMainPage extends YandexMarketBasePage{
    private String bannerImageSelector = "//div[@class = \"_21618EJj8k\"]";
    private String scrollBoxesSelector = "//div[@class = \"section _32PriwSr5B _3bo97ldS0I _2pc-e5GHOv uVxPQP6pdS\"]/div[@data-tid = \"b675845d\"]/.."; // Сделать более короткую строку
    private String scrollBoxProductsSelector = ".//div[@class = \"XTSL4OaxYO CuWJ7r8WeJ\"]";
    private String mainBlocksOfPageSelector = "//div[@data-apiary-widget-name = \"@MarketNode/LazyLoader\"]";
    private String scrollBoxRightButtonArrowSelector = ".//div[@class = \"_29IufIopC6 _1Ka8jv5AFS _1iHQbk45Bm\"]";
    private String scrollBoxLeftButtonArrowSelector = ".//div[@class = \"_29IufIopC6 _3zxyyOSK7R _1iHQbk45Bm\"]";
    private String advertisingBannersSelector = ".//div[@class = \"Z4A5FZBDy2 D2h0Msn-ZE _2-DS8LcjqG shape-rectangle _1JDoLWhp7k\"]";

    public YandexMarketMainPage() {
        fullPageLoad();
        getLogoYandexMarketButton().scrollTo();
    }

    public ElementsCollection getScrollBoxProducts(String scrollBoxHeaderName) { return getScrollBox(scrollBoxHeaderName).findAll(By.xpath(scrollBoxProductsSelector)); }

    public ElementsCollection getAdvertisingBanners() { return $$(By.xpath(advertisingBannersSelector)); }

    public SelenideElement getScrollBoxProduct(String scrollBoxHeaderName, String productName) { return getScrollBoxProducts(scrollBoxHeaderName).findBy(text(productName)); }

    public SelenideElement getBannerImage() {
        return $(By.xpath(bannerImageSelector));
    }

    public SelenideElement getScrollBox(String scrollBoxHeaderName) { return $$(By.xpath(scrollBoxesSelector)).findBy(text(scrollBoxHeaderName)); }

    public SelenideElement getScrollBoxRightButtonArrow(String scrollBoxHeaderName) { return getScrollBox(scrollBoxHeaderName).find(By.xpath(scrollBoxRightButtonArrowSelector)); }

    public SelenideElement getScrollBoxLefttButtonArrow(String scrollBoxHeaderName) { return getScrollBox(scrollBoxHeaderName).find(By.xpath(scrollBoxLeftButtonArrowSelector)); }

    public void fullPageLoad() { $$(By.xpath(mainBlocksOfPageSelector)).forEach(SelenideElement::scrollTo); }

    public YandexMarketSearchResults search(String searchText) {
        getSearchField().click();
        getSearchField().sendKeys(searchText);
        getSearchButton().click();
        return new YandexMarketSearchResults();
    }
}
