package scripts.nativetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;
import org.testng.annotations.Test;
import scripts.Hooks;
import setup.Capabilities;

@Test(groups = "native")
public class SimpleNativeTests extends Hooks {

    @Test(description = "Click on the button 'Add contact' and make sure all contact fields appear")
    public void simplestTest() throws Exception {
        String appPackage = params.get(Capabilities.APP_PACKAGE.get());
        driver().findElement(By.id(appPackage + ":id/addContactButton")).click();

        // Check Target Account, Contact Name, Contact Phone
        WebElement targetAccount = driver().findElement(By.id(appPackage + ":id/accountSpinner"));
        Assert.assertTrue(targetAccount.isDisplayed());

        WebElement contactName = driver().findElement(By.id(appPackage + ":id/contactNameEditText"));
        Assert.assertTrue(contactName.isDisplayed());

        WebElement contactPhone = driver().findElement(By.id(appPackage + ":id/contactPhoneEditText"));
        Assert.assertTrue(contactPhone.isDisplayed());

        // Check virtual keyboard appears
        Keyboard keyboard = driver().getKeyboard();
        Assert.assertTrue(keyboard != null);
    }
}
