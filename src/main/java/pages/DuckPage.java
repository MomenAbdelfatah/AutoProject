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

    Bot bot;

    By logo = By.xpath("//div[contains(@class,'headerWrapDesktop')]//img");
    By linksList = By.xpath("//a[@data-testid='result-extras-url-link']");
    By searchBox = By.xpath("//input[@aria-label='Search with DuckDuckGo']");
    By searchButton = By.xpath("//button[@type='submit']");
//    By linkResultText = By.xpath(".//a[@data-testid='result-extras-url-link']");
    By resultTitle = By.xpath("//a[@data-testid='result-title-a']//span");

    public DuckPage(Bot bot) {
        this.bot=bot;
    }

    public String getTitle() {
        return bot.getTitle();}

    public Boolean getPageLogo() {
        return bot.isDisplayed(logo);
    }

    public String getLinkText(String text, int Index) {
        bot.sendKeys(searchBox, text);
        List<WebElement> links = bot.findList(linksList);
        System.out.println(links.size());
        return links.get(Index).getDomAttribute("href");

    }


    public String getLinkTitle() {
        bot.sendKeys(resultTitle, "testng" + Keys.ENTER);
        List<WebElement> links = bot.findList(resultTitle);
        return links.get(3).getText();

    }


}
