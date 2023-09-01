package Steps;

import io.qameta.allure.Step;
import pages.CatalogPages;

import static pages.CatalogPages.catalogPage;
import static util.DriverManager.getDriver;
import static util.FindElements.*;
import static util.Screenshot.saveAllureScreenshot;


public class CatalogStep {
    CatalogPages catalogPages = new CatalogPages();

    public CatalogStep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findS(catalogPages.heading);
    }

    @Step("Установка фильтра цены минимум - {min} и максимум - {max}")
    public void setMinMax(String min, String max) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findS(catalogPages.priceMin).sendKeys(min);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findS(catalogPages.priceMax).sendKeys(max);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saveAllureScreenshot();
    }

    @Step("Установка фильтра по способу доставки {type}")
    public void selectDelivery(String type) {
        findX(".//span [text()='" + type + "']").click();
        saveAllureScreenshot();
    }

    @Step("Показать весь фильтр по бренду")
    public void checkDelicacyFiltersAll() {
        findAllS(catalogPages.manufacturerShowAll).get(0).click();
        saveAllureScreenshot();
    }

    @Step("Установка фильтра по бренду {filter}")
    public void checkDelicacy(String filter){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findS("input[id*=textfield]").clear();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findS("input[id*=textfield]").sendKeys(filter);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findX(".//span [text()='" + filter + "']").click();
        saveAllureScreenshot();
    }

    @Step("Получение имени элемента с индексом - {index}")
    public String getNameElement(int index) {
        saveAllureScreenshot();
        return findAllS(catalogPages.element).get(index - 1).getText();
    }

    @Step("Перейти на новую страницу элемента с индексом - {index}")
    public void clickElement(int index) {
        saveAllureScreenshot();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findAllS(catalogPages.element).get(index - 1).click();
        String page = null;
        for (String win:getDriver().getWindowHandles()) {
            if (win != catalogPage) {
                page = win;
            }
        }
        getDriver().switchTo().window(page);
    }
}
