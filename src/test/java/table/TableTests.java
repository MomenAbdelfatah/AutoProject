package table;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TablePage;

public class TableTests extends BaseTests {
    private TablePage tablePage;

    @BeforeMethod
    public void pageSetup() {
        bot.NavigateTo("https://www.w3schools.com/html/html_tables.asp");
        tablePage = new TablePage(bot);
    }

    @Test
    public void testCountry() {
        Assert.assertEquals(tablePage.getCountryValue(), "Austria");
    }
}
