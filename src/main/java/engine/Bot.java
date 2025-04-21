package engine;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

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

    public void NavigateTo(String url) {
        wait.until(
                d -> {
                    d.get(url);
                    System.out.println("Navigated to " + url);
                    return true;
                });
    }

    public String getTitle() {
        return wait.until(
                d -> {
                    String title = d.getTitle();
                    System.out.println("Page title is " + title);
                    return title;
                });
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

    public void click(By by) {
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

    public List<WebElement> findList(By by) {
        return wait.until(
                d -> {
                    d.findElement(by).isDisplayed();
                    System.out.println("Found elements with " + by);
                    return d.findElements(by);
                });

    }

    public void DragAndDrop(By source, By target) {
        wait.until(
                d -> {
                    Actions actions = new Actions(d);
                    actions.dragAndDrop(d.findElement(source), d.findElement(target)).perform();
                    System.out.println("Dragged and dropped from " + source + " to " + target);
                    return true;
                });
    }

    public String getText(By by) {
        return wait.until(
                d -> {
                    String text = d.findElement(by).getText();
                    System.out.println("Text is " + text);
                    return text;
                });
    }
}


