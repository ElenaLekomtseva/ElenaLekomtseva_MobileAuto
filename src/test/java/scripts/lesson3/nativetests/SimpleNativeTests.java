package scripts.lesson3.nativetests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.Test;
import scripts.lesson3.Hooks;
import setup.Driver;
import setup.PropertyFile;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTests extends Hooks {

    protected SimpleNativeTests() throws IOException {
        super(PropertyFile.NATIVE);
    }

    @Test(description = "Click on the button 'Add contact' and make sure all contact fields appear")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();

        // Check Target Account, Contact Name, Contact phone appears
        assert driver().findElement(By.id(app_package_name + "accountSpinner")).isDisplayed() : "Target Account selection is not displayed";
        assert driver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Target Account\"]")).getAttribute("text").contains("Target Account") : "Improper title of Target Account";

        // TODO: Check virtual keyboard appears


        // TODO: heck pop-up "Tap to Google Search and more" appears: ??????????

        System.out.println("Simplest Appium test done");
    }
}
