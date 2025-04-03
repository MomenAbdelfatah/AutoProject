package draganddrop;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTests extends BaseTests {

    private DragAndDropPage dragAndDropPage;

    @BeforeMethod
    public void pageSetup(){
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        dragAndDropPage = new DragAndDropPage(driver);
    }

    @Test
    public void testDragAndDrop(){
        Assert.assertEquals(dragAndDropPage.dragAndDropBox(),"Dropped!");
    }
}
