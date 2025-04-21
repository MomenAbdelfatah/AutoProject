package duck;

import base.BaseTests;
import engine.JsonReader;
import org.json.JSONObject;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DuckPage;

public class DuckTests extends BaseTests {

    private DuckPage duckPage;


    @BeforeMethod
    public void pageSetup() {
        bot.NavigateTo(data.getString("duckUrl"));
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
        Assert.assertEquals(duckPage.getLinkText(data.getString("searchInputT3") + Keys.ENTER, 0), "https://www.selenium.dev/documentation/webdriver/");
    }


    @Test
    public void testSearchResultsLinkText5() {
        Assert.assertTrue(duckPage.getLinkText(data.getString("searchInputT5") + Keys.ENTER, 1).contains("https://www.linkedin.com"));
    }


}
