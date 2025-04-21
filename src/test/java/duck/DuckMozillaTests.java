package duck;

import base.BaseTests;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DuckPage;

public class DuckMozillaTests extends BaseTests {

    private DuckPage duckPage;

    @BeforeMethod
    public void pageSetup() {
        bot.NavigateTo("https://duckduckgo.com/");
        duckPage = new DuckPage(bot);
    }
    @Test
    public void testSearchResultsLinkTitle(){
        Assert.assertEquals(duckPage.getLinkTitle(),"TestNG Tutorial");

    }
}
