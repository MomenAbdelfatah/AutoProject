package checkbox;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

public class CheckBoxTests extends BaseTests {
    private CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    public void testCheckBoxScenario() {
        checkBoxPage.clickCheckBox1();
        Assert.assertTrue(checkBoxPage.checkIfSelected());
    }
}
