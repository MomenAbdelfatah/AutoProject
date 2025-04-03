package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage {
    private WebDriver driver;
    private By uploadButton = By.id("file-submit");
    private By inputField = By.id("file-upload");
    private By uploadResultMessage = By.xpath("//div//h3");

    public UploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public String uploadImage() {
        driver.findElement(inputField).sendKeys("C:\\Users\\momen\\OneDrive\\Pictures\\friends.jpg");
        driver.findElement(uploadButton).click();
        return driver.findElement(uploadResultMessage).getText();
    }
}
