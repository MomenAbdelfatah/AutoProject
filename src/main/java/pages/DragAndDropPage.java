package pages;

import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    private Bot bot;
    private By dragBox = By.id("draggable");
    private By dropBox = By.id("droppable");
    private By droppedStatus = By.xpath("//div[@id='droppable']//p");

    public DragAndDropPage(Bot bot) {
        this.bot = bot;
    }

    public String dragAndDropBox() {
        bot.DragAndDrop(dragBox,dropBox);
        return bot.getText(droppedStatus);
    }
}
