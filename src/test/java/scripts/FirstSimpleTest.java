package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {

    @BeforeClass(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareAndroidNative();
        //prepareAndroidWeb();
    }

    @Test(description = "This simple test just click on button 'Add contact'")
    public void simplestTest() throws InterruptedException {
        //Find element by id
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        //WebElement button = driver.findElement(add_btn);

        //Find element by class
        //WebElement button = driver.findElement(By.className("android.widget.Button"));

        //Find element by xpath
        WebElement button = driver.findElement(By.xpath("//android.widget.Button"));

        button.click();
        System.out.println("Simplest Appium test done");
    }

    //@Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get("http://iana.org");
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

    @AfterClass(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}

