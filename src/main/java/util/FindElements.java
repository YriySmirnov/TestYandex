package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static util.DriverManager.getDriver;

public class FindElements {

    public static WebElement findS(String element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
    }
    public static WebElement findX(String element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public static List<WebElement> findAllS(String element) {
        return getDriver().findElements(By.cssSelector(element));
    }
}
