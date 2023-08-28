package util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static util.DriverManager.getDriver;

public class Screenshot {
    @Attachment(value = "Page screenshot", type = "image/png",fileExtension = ".png")
    public static byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
