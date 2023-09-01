package Steps;

import io.qameta.allure.Step;
import pages.ElementPages;

import java.util.ArrayList;

import static pages.CatalogPages.catalogPage;
import static util.DriverManager.getDriver;
import static util.FindElements.*;
import static util.Screenshot.saveAllureScreenshot;

public class ElementStep {
    ElementPages elementPages = new ElementPages();

    public ElementStep() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<String> newTab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(newTab.get(1));
        findX(elementPages.heading);
        saveAllureScreenshot();
    }

    @Step("Добавить выбранный в сравнение")
    public void compare() {
        findX(elementPages.compareAdd).click();
        saveAllureScreenshot();
    }

    @Step("Вернуться на первую вкладку")
    public void returnBack(){
        getDriver().switchTo().window(catalogPage);
        saveAllureScreenshot();
    }

    @Step("Перейти на страницу сравнения")
    public void viewCompare() {
        saveAllureScreenshot();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findX(elementPages.compareInf).click();
    }
}
