package Steps;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import pages.HomePages;

import static util.DriverManager.getDriver;
import static util.FindElements.*;
import static util.Screenshot.saveAllureScreenshot;

public class HomeStep {
    HomePages homePages = new HomePages();

    public HomeStep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findS(homePages.heading);
    }

    @Step("Открыть каталог")
    public void selectCatalog() {
        findS(homePages.buttonCatalog).click();
        saveAllureScreenshot();
    }

    @Step("Навести на раздел Зоотовары")
    public void selectZoo() {
        saveAllureScreenshot();
        new Actions(getDriver()).moveToElement(findX(homePages.catalogZoo)).perform();
    }

    @Step("Выбрать в первом разделе Лакомства")
    public void checkDelicacy() {
        saveAllureScreenshot();
        findX(homePages.linkZooDelicacy).click();
    }
}
