package scripts.webtests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import scripts.Hooks;
import setup.PropertyFile;

import java.io.IOException;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    protected SimpleWebTests() throws IOException {
        super(PropertyFile.WEB);
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT); // this always ends OK; it's a drawback.
        driverWait().
                until(
                        ExpectedConditions.
                                urlToBe(SUT + "/")); // temporary solution; it would be better to use regexp

        Assert.assertTrue(driver().getCurrentUrl().contains(SUT));
        Assert.assertEquals(driver().getTitle(), SUT_TITLE);
    }

}
