# ElenaLekomtseva_MobileAuto
## Exercise 2
1. Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.
Package [lesson 2](https://github.com/ElenaLekomtseva/ElenaLekomtseva_MobileAuto/tree/master/src/test/java/scripts/lesson2).
2. For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?
```java
    //Find element by id
    String app_package_name = "com.example.android.contactmanager:id/";
    By add_btn = By.id(app_package_name + "addContactButton");
    WebElement button = driver.findElement(add_btn);

    //Find element by class
    WebElement button = driver.findElement(By.className("android.widget.Button"));

    //Find element by xpath
    WebElement button = driver.findElement(By.xpath("//android.widget.Button"));
```
3. Modify existing tests to run on a real device. What should be changed?
```java
    // Changed deviceName
    capabilities.setCapability("deviceName","1215fc9a61d13005");
```
4. Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?
```
I enabled developer mode on mobile and USB debugging.
After connected the mobile to the laptop by USB, started appium and executed project.
```
5. What should be improved/changed in existing test code? Why, for what?
```
- Fix hardcode variables and absolute path
- Change the code for easy run the native test and the web test, without commenting code.
- Remove the waiting implementation through "Thread.sleep"
- Implement init drive in seperate a method or class. Remove code duplication.
- No tests
```
