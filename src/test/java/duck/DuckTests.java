package duck;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DuckPage;

public class DuckTests extends BaseTests {

    private DuckPage duckPage;

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://duckduckgo.com/");
        duckPage = new DuckPage(driver);
    }

    @Test
    public void testPageTitle(){
        String title =  duckPage.getTitle();

        Assert.assertEquals(title,"Google");


    }

    @Test
    public void testPageLogoVisibility(){
        Assert.assertTrue(duckPage.getPageLogo().isDisplayed());

    }

    @Test
    public void testSearchResultsLinkText(){
        Assert.assertEquals(duckPage.getLinkText("Selenium Webdriver",0),"https://www.selenium.dev/documentation/webdriver/");
    }


    @Test
    public void testSearchResultsLinkText5(){
        Assert.assertTrue(duckPage.getLinkText("Cucumber IO",1).contains("https://www.linkedin.com"));
    }


}
