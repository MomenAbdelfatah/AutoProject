package pages;

import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DuckPage {

    private WebDriver driver;
    Bot bot;

    By logo = By.xpath("//section[@class='header_headerLeft__rW6nD header_headerSection___XMRI']//a[@title='Learn about DuckDuckGo']");
    By linksList = By.xpath("//li[@data-layout='organic']");
    By searchBox = By.xpath("//input[@aria-label='Search with DuckDuckGo']");
    By searchButton = By.xpath("//button[@type='submit']");
    By linkResultText = By.xpath(".//a[@data-testid='result-extras-url-link']");
    By resultTitle = By.xpath(".//a[@data-testid='result-title-a']//span");

    public DuckPage(WebDriver driver) {
        this.driver = driver;
        bot = new Bot(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public Boolean getPageLogo() {
        return bot.isDisplayed(logo);
    }

    public String getLinkText(String text, int Index) {
        bot.sendKeys(searchBox, text);
        bot.findList(linksList);
        List<WebElement> links = driver.findElements(linksList);

        return links.get(Index).findElement(linkResultText).getDomAttribute("href");

    }


    public String getLinkTitle() {
        bot.sendKeys(resultTitle, "testng" + Keys.ENTER);
        bot.findList(linksList);
        List<WebElement> links = driver.findElements(linksList);

        return links.get(3).findElement(resultTitle).getText();

    }


}
