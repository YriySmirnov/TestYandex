package Steps;

import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import pages.ComparePages;

import static util.DriverManager.getDriver;
import static util.FindElements.*;
import static util.Screenshot.saveAllureScreenshot;

public class CompareStep {
    ComparePages comparePage = new ComparePages();

    public CompareStep() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //findX(comparePage.heading);
        saveAllureScreenshot();
    }

    @Step("Получение имени элемента с индексом - {index} в сравнениваемых")
    public String getName(int index) {
        saveAllureScreenshot();
        return findAllS(comparePage.nameElements).get(index - 1).getText();
    }

    @Step("Получение цены элемента с индексом - {index} в сравнениваемых")
    public int getPrice(int index) {
        saveAllureScreenshot();
        return Integer.valueOf(findAllS(comparePage.elementPrice).get(index - 1).getAttribute("data-autotest-value"));
    }

    @Step("Удаление элемента с индексом - {index} из сравнениваемых")
    public void delElement(int index) {
        new Actions(getDriver()).moveToElement(findAllS(comparePage.elementDel).get(index*2-1)).perform();
        findAllS(comparePage.elementDel).get(index*2-1).click();
        saveAllureScreenshot();
    }

    @Step("Есть ли элемент - {element} на странице сравнения")
    public int findElement(String element) {
        saveAllureScreenshot();
        return findAllS(comparePage.nameElements).indexOf(element);
    }

    @Step("Удаление всех элементов сравнения")
    public void compareClear() {
        findX(comparePage.compareClear).click();
        saveAllureScreenshot();
    }

    @Step("Получение количества элементов сравнения")
    public int amountElements() {
        saveAllureScreenshot();
        return findAllS(comparePage.nameElements).size();
    }
}
