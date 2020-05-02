package ru.yandex.market.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.market.ui.pageObject.YandexMarketMainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static ru.yandex.market.ui.CustomConditions.valueInAttribute;

public class Tests {
    private final String URL = "https://market.yandex.ru/";
    private YandexMarketMainPage yandexMarketMainPage;

    @DataProvider(name = "NamesOfScrollBoxes")
    public static Object[][] namesOfScrollBoxes() {
        return new Object[][]{
                {"Профилактика и лечение в сезон простуд"},
                {"Приглядитесь к этим предложениям"},
                {"Популярные товары"}
        };
    }

    @DataProvider(name = "NamesOfScrollBoxesWithProduct")
    public static Object[][] namesOfScrollBoxesWithProduct() {
        return new Object[][]{
                {"Профилактика и лечение в сезон простуд",
                        "от 132 ₽ Антисептический гель для рук Harmony of Body с экстрактом зеленого чая",
                        "от 600 ₽ Перчатки смотровые Archdale NitriMAX",
                        "от 669 ₽ Ингавирин капс. 90мг №10",
                        "от 662 ₽ Перчатки Aviora Виниловые неопудренные",
                        "от 140 ₽ Гель для рук Витэкс Идеальные ручки Антибактериальный очищающий",
                        "от 650 ₽ Перчатки смотровые Alliance Standard нитриловые",
                        "от 539 ₽ Галавит таб. подъязыч. 25мг №20",
                        "от 686 ₽ Перчатки Paclan виниловые неопудренные",
                        "от 459 ₽  Антисептическое средство для обработки рук и ступней Domix Green Professional Тоталдез гель",
                        "от 950 ₽ Перчатки смотровые Benovy Nitrile Chlorinated",
                        "от 391 ₽ Мирамистин р-р д/местн. прим. 0,01% 150 мл (с расп.)",
                        "от 637 ₽ Перчатки Aviora Нитриловые",
                        "от 125 ₽ Гель для рук Зеленая Дубрава защитный с хлоргексидином",
                        "от 291 ₽ Перчатки смотровые John Pack виниловые",
                        "от 1 150 ₽ Триазавирин капс. 250мг №20",
                        "от 590 ₽ Перчатки Benovy виниловые одноразовые"},
                {"Приглядитесь к этим предложениям",
                        "Концентрированный кондиционер для детского белья Нежное прикосновение Synergetic"},
                {"Популярные товары",
                        "Elizavecca Milky Piggy Пузырьковая глиняная маска"}
        };
    }

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

    @Test(dataProvider = "NamesOfScrollBoxes")
    public void testScrollBoxesHeaderName(String nameOfScrollBox) {
        yandexMarketMainPage.getScrollBox(nameOfScrollBox).shouldHave(text(nameOfScrollBox));
    }

    @Test(dataProvider = "NamesOfScrollBoxes")
    public void testScrollBoxesNumberOfProducts(String nameOfScrollBox) {
        yandexMarketMainPage.getScrollBoxProducts(nameOfScrollBox).shouldHave(sizeGreaterThan(5));
    }

    @Test(dataProvider = "NamesOfScrollBoxes")
    public void testScrollBoxesButtons(String nameOfScrollBox) {
        yandexMarketMainPage.getScrollBoxRightButtonArrow(nameOfScrollBox).shouldBe(exist).click();
        yandexMarketMainPage.getScrollBoxLefttButtonArrow(nameOfScrollBox).shouldBe(exist).click();
    }

    // Нужно заполнить dataProvider NamesOfScrollBoxesWithProduct актуальным набором тестовых данных т.к. данные динамические.
    @Test(dataProvider = "NamesOfScrollBoxesWithProduct")
    public void testScrollBoxesNamesOfProducts(String scrollBoxName, String ... namesOfProducts) {
        yandexMarketMainPage.getScrollBoxProducts(scrollBoxName).shouldHave(texts(namesOfProducts));
    }
}
