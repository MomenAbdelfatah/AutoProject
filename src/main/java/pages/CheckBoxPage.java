package pages;

import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckBoxPage {
    private Bot bot;
    private By checkBoxes = By.xpath("//input");

    public CheckBoxPage(Bot bot) {
        this.bot = bot;
    }

    public void clickCheckBox1() {
        bot.findList(checkBoxes).getFirst().click();
    }

    public boolean checkIfSelected() {
        List<WebElement> boxList = bot.findList(checkBoxes);
        return boxList.get(0).isSelected() && boxList.get(1).isSelected();
    }
}
