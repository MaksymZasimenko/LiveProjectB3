package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MiscUtils {

    public static WebElement highlightElement(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 3px solid red; background: #fffa61eb");
        sleep(500);
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");

        return element;
    }


    public static void sleep(long millis){

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

