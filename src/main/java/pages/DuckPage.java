package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DuckPage {

    private WebDriver driver;
    By logo = By.xpath("//section[@class='header_headerLeft__rW6nD header_headerSection___XMRI']//a[@title='Learn about DuckDuckGo']");
    By linksList = By.xpath("//li[@data-layout='organic']");
    By searchBox = By.xpath("//input[@aria-label='Search with DuckDuckGo']");
    By searchButton = By.xpath("//button[@type='submit']");
    By linkResultText = By.xpath(".//a[@data-testid='result-extras-url-link']");
    By resultTitle = By.xpath(".//a[@data-testid='result-title-a']//span");

    public DuckPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement getPageLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        return driver.findElement(logo);
    }

    public String getLinkText(String text,int Index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(linksList));

        List<WebElement> links = driver.findElements(linksList);
        WebElement firstElement = links.get(Index);
        return firstElement.findElement(linkResultText).getDomAttribute("href");

    }


    public String getLinkTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        driver.findElement(searchBox).sendKeys("testng");
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(linksList));
        List<WebElement> links = driver.findElements(linksList);
        WebElement fourthElement = links.get(3);
        return fourthElement.findElement(resultTitle).getText();

    }


}
