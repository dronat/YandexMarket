package ru.yandex.market.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.market.ui.pageObject.YandexMarketMainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static ru.yandex.market.ui.CustomConditions.valueInAttribute;

public class Tests {
    private final String URL = "https://market.yandex.ru/";
    private YandexMarketMainPage yandexMarketMainPage;

    @BeforeMethod
    public void beforeTest() {
        open(URL);
        yandexMarketMainPage = new YandexMarketMainPage();
    }

    @Test
    public void testLogoYandexMarketButton() {
        yandexMarketMainPage.getLogoYandexMarketButton().click();
        Assert.assertEquals(url(), URL);
    }

    @Test
    public void testSearch() {
        String textForSearch = "Телефоны";
        yandexMarketMainPage.search(textForSearch).getTitle().shouldHave(valueInAttribute("text", textForSearch));
    }

    @Test
    public void testScrollBoxesHeaderName() {
        String firstScrollBoxName = "Профилактика и лечение в сезон простуд";
        String SecondScrollBoxName = "Приглядитесь к этим предложениям";
        String ThirdScrollBoxName = "Популярные товары";

        yandexMarketMainPage.getScrollBox(firstScrollBoxName).shouldHave(text(firstScrollBoxName));
        yandexMarketMainPage.getScrollBox(SecondScrollBoxName).shouldHave(text(SecondScrollBoxName));
        yandexMarketMainPage.getScrollBox(ThirdScrollBoxName).shouldHave(text(ThirdScrollBoxName));
    }

    /*@Test
    public void testScrollBoxesProducts() {

    }*/
}
