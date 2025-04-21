package pages;

import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TablePage {
    private Bot bot;
    private By countryValue = By.xpath("//table[@id='customers']//td[text()='Ernst Handel']/..//td[3]");

    public TablePage(Bot bot) {
        this.bot = bot;
    }

    public String getCountryValue() {
              return bot.getText(countryValue);
    }
}
