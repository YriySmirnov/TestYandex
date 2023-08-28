import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static util.DriverManager.*;

public class TestSetupStart {
    WebDriver driver;

    @BeforeEach
    @Step("Открыть ссылку https://market.yandex.ru в браузере на полный экран")
    void setup() {
        driver = getDriver();
    }

    @AfterEach
    void setupEnd(){
        quitDriver();
    }

    @Test
    @Description("Тестирование market.yandex.ru по сценаию")
    void Test() {
        new TestScenary().Test();
    }
}