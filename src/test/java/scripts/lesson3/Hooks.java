package scripts.lesson3;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;
import setup.PropertyFile;

import java.io.IOException;

@Test(groups = {"native","web"})
public class Hooks extends Driver {
    private PropertyFile propertyFile;

    public Hooks(PropertyFile propertyFile) {
        this.propertyFile = propertyFile;
    }

    /**
     * Required variables will be initialized by inherited constructor
     * @throws IOException
     */
    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        setPropertyFile(propertyFile);
        prepareDriver();

        System.out.println("Driver prepared");

    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();

        System.out.println("Driver closed");
    }
}
