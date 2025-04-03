package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    private WebDriver driver;
    private By dragBox = By.id("draggable");
    private By dropBox = By.id("droppable");
    private By droppedStatus = By.xpath("//div[@id='droppable']//p");

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public String dragAndDropBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(dragBox), driver.findElement(dropBox)).perform();
        return driver.findElement(droppedStatus).getText();
    }
}
