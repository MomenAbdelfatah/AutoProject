package upload;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UploadPage;

public class UploadTests extends BaseTests {

    private UploadPage uploadPage;

    @BeforeMethod
    public void pageSetup(){
        bot.NavigateTo("https://the-internet.herokuapp.com/upload");
        uploadPage = new UploadPage(bot);
    }


    @Test
    public void testUploadImage() {
        Assert.assertEquals(uploadPage.uploadImage(), "File Uploaded!");
    }
}
