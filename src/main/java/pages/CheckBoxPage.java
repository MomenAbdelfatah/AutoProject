package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckBoxPage {
    private WebDriver driver;
    private By checkBoxes = By.xpath("//input");

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckBox1() {
        driver.findElements(checkBoxes).getFirst().click();
    }

    public boolean checkIfSelected() {
        List<WebElement> boxList = driver.findElements(checkBoxes);
        return boxList.get(0).isSelected() && boxList.get(1).isSelected();
    }
}
