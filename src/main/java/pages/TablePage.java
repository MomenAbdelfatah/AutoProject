package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TablePage {
    private WebDriver driver;
    private By countryValue = By.xpath("//table[@id='customers']//td[text()='Ernst Handel']/..//td[3]");

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCountryValue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryValue));

        WebElement countryElement = driver.findElement(countryValue);
        return countryElement.getText();
    }
}
