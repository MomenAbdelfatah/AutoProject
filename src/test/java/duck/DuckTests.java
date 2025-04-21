package duck;

import base.BaseTests;
import engine.Bot;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DuckPage;

public class DuckTests extends BaseTests {

    private DuckPage duckPage;

    @BeforeMethod
    public void pageSetup() {
        bot.NavigateTo("https://duckduckgo.com/");
        duckPage = new DuckPage(bot);
    }

    @Test
    public void testPageTitle() {
        Assert.assertEquals(duckPage.getTitle(), "Google");
    }

    @Test
    public void testPageLogoVisibility() {
        Assert.assertTrue(duckPage.getPageLogo());

    }

    @Test
    public void testSearchResultsLinkText() {
        Assert.assertEquals(duckPage.getLinkText("Selenium Webdriver" + Keys.ENTER, 0), "https://www.selenium.dev/documentation/webdriver/");
    }


    @Test
    public void testSearchResultsLinkText5() {
        Assert.assertTrue(duckPage.getLinkText("Cucumber IO" + Keys.ENTER, 1).contains("https://www.linkedin.com"));
    }


}
