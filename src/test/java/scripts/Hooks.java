package scripts;

import org.testng.ITestContext;
import org.testng.annotations.*;
import setup.Driver;

import java.io.IOException;
import java.util.HashMap;

@Test(groups = {"native","web"})
public class Hooks extends Driver {

    /**
     * Required variables will be initialized by inherited constructor
     * @throws IOException
     */
    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp(ITestContext context) throws Exception {
        params = new HashMap<>(context.getCurrentXmlTest().getAllParameters());
        prepareDriver();

        System.out.println("Driver prepared");

    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();

        System.out.println("Driver closed");
    }
}
