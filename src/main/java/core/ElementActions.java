package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ElementActions {

    public static void sleep(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void isVisibility (WebElement element){
        new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(Global.WAIT)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void isVisibility(WebElement element,int waitSeconds){
        BasePage.getDriver().manage().timeouts().implicitlyWait(waitSeconds, TimeUnit.SECONDS);
        new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(waitSeconds)).until(ExpectedConditions.visibilityOf(element));
        BasePage.getDriver().manage().timeouts().implicitlyWait(Global.WAIT,TimeUnit.SECONDS);
    }

    public static void isClickable(WebElement element){
        new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(Global.WAIT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void isVisibilityIsClickableClick(WebElement element){
        isVisibility(element);
        element.click();
    }

    public static void isVisibilityIsClickableClick(WebElement element, WebElement waitElement){
        isVisibility(element);
        element.click();
        isVisibility(waitElement);
    }

    public static void clearSendKeys(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static void clearSendKeysAndEnter(WebElement element, String text){
        element.clear();
        element.sendKeys(text, Keys.ENTER);
    }

}
