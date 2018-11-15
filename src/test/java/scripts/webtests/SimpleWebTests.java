package scripts.webtests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import scripts.Hooks;
import setup.Constants;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    @Test(description = "Open website")
    public void webTest() throws Exception {
        String sut = params.get(Constants.SUT.get());
        driver().get(sut); // this always ends OK; it's a drawback.
        driverWait().
                until(
                        ExpectedConditions.
                                urlToBe(sut + "/")); // temporary solution; it would be better to use regexp

        Assert.assertTrue(driver().getCurrentUrl().contains(sut));
        Assert.assertEquals(driver().getTitle(), params.get(Constants.SUT_TITLE.get()));
    }

}
