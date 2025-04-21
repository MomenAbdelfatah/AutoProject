package pages;

import engine.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage {
    private Bot bot;
    private By uploadButton = By.id("file-submit");
    private By inputField = By.id("file-upload");
    private By uploadResultMessage = By.xpath("//div//h3");

    public UploadPage(Bot bot) {
        this.bot = bot;
    }

    public String uploadImage(String path) {
        bot.sendKeys(inputField,path);
        bot.click(uploadButton);
        return bot.getText(uploadResultMessage);
    }
}
