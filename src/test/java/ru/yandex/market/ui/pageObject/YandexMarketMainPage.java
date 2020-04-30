package ru.yandex.market.ui.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class YandexMarketMainPage extends YandexMarketBasePage{
    private String bannerImageSelector = "//div[@class = \"_21618EJj8k\"]";
    private String scrollBoxesSelector = "//div[@class = \"section _32PriwSr5B _3bo97ldS0I _2pc-e5GHOv uVxPQP6pdS\"]/div[@data-tid = \"b675845d\"]/..";
    private String scrollBoxesProductsSelector = "//div[@class = \"XTSL4OaxYO CuWJ7r8WeJ\"]";
    private String bottomElementOfPageSelector = "//div[@class = \"_2q2DD9y4s7\"]";
    private String mainBlocksOfPageSelector = "//div[@data-apiary-widget-name = \"@MarketNode/LazyLoader\"]";

    public YandexMarketMainPage() {
        fullPageLoad();
        getLogoYandexMarketButton().scrollTo();
    }

    public ElementsCollection getScrollBoxProducts(String scrollBoxHeaderName) { return getScrollBox(scrollBoxHeaderName).findAll(scrollBoxesProductsSelector); }

    public SelenideElement getBannerImage() {
        return $(By.xpath(bannerImageSelector));
    }

    public SelenideElement getScrollBox(String scrollBoxHeaderName) { return $$(By.xpath(scrollBoxesSelector)).findBy(text(scrollBoxHeaderName)); }

    public void fullPageLoad() {
        $$(By.xpath(mainBlocksOfPageSelector)).forEach(SelenideElement::scrollTo);
    }

    public YandexMarketSearchResults search(String searchText) {
        getSearchField().click();
        getSearchField().sendKeys(searchText);
        getSearchButton().click();
        return page(YandexMarketSearchResults.class);
    }
}
