package com.chanyshev92;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WindowType;
import pages.YandexMarketPage;
import pages.YandexMarketProductListPage;
import pages.YandexStartPage;

public class Test extends WebDriverProvider {
    @DisplayName("Поиск ноутбуков HP и Lenovo на Я.Маркете в диапазоне 10-900к")
    @org.junit.jupiter.api.Test
    public void testForNotebooksOnYM(){

        chromeDriver.get("https://yandex.ru");
        YandexStartPage yandexStartPage = new YandexStartPage(chromeDriver);

        String hrefMarket = yandexStartPage.getMarketElement().getAttribute("href");

        chromeDriver.switchTo().newWindow(WindowType.TAB);
        chromeDriver.get(hrefMarket);

        YandexMarketPage yandexMarketPage = new YandexMarketPage(chromeDriver);
        String hrefSubcategory = yandexMarketPage.findSubCategory("Компьютеры", "Ноутбуки").getAttribute("href");
        chromeDriver.get(hrefSubcategory);

        YandexMarketProductListPage listPage=new YandexMarketProductListPage(chromeDriver);
        listPage.checkboxOfManufacturer("Производитель","HP").click();
        listPage.checkboxOfManufacturer("Производитель","Lenovo").click();
        //System.out.println(listPage.getResults().stream().findFirst().get().getAttribute("title"));
        listPage.changeShowCountIfNotEquals("Показывать по 12");

        int i=0;

    }
}
