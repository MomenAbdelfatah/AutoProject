package engine;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Bot {

    private final Wait<WebDriver> wait;

    public Bot(WebDriver driver) {
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public void sendKeys(By by, String text) {
        wait.until(
                d -> {
                    d.findElement(by).clear();
                    d.findElement(by).sendKeys(text);
                    System.out.println("Typed " + text + " into " + by);
                    return true;
                });
    }

    public void click(By by, String text) {
        wait.until(
                d -> {
                    d.findElement(by).click();
                    System.out.println("Clicked " + by);

                    return true;
                });
    }


    public Boolean isDisplayed(By by) {
        return wait.until(
                d ->
                        d.findElement(by).isDisplayed());
    }

    public void findList(By by) {
        wait.until(
                d ->
                        d.findElements(by));
    }
}


