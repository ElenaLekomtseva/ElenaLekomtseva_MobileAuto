package scripts.nativetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;
import org.testng.annotations.Test;
import scripts.Hooks;
import setup.PropertyFile;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTests extends Hooks {

    protected SimpleNativeTests() throws IOException {
        super(PropertyFile.NATIVE);
    }

    @Test(description = "Click on the button 'Add contact' and make sure all contact fields appear")
    public void simplestTest() throws Exception {
        driver().findElement(By.id(APP_PACKAGE + ":id/addContactButton")).click();

        // Check Target Account, Contact Name, Contact Phone
        WebElement targetAccount = driver().findElement(By.id(APP_PACKAGE + ":id/accountSpinner"));
        Assert.assertTrue(targetAccount.isDisplayed());

        WebElement contactName = driver().findElement(By.id(APP_PACKAGE + ":id/contactNameEditText"));
        Assert.assertTrue(contactName.isDisplayed());

        WebElement contactPhone = driver().findElement(By.id(APP_PACKAGE + ":id/contactPhoneEditText"));
        Assert.assertTrue(contactPhone.isDisplayed());

        // Check virtual keyboard appears
        Keyboard keyboard = driver().getKeyboard();
        Assert.assertTrue(keyboard != null);
    }
}
