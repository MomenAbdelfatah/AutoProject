package base;

import engine.Bot;
import engine.JsonReader;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTests {

    protected WebDriver driver;
    protected Bot bot;
    protected JSONObject data;


    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) throws Exception {
        if (browser.equalsIgnoreCase("mozilla")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        data = JsonReader.readJson("testdata/data.json");
        bot = new Bot(driver);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
