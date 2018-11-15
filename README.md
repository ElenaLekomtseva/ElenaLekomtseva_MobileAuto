# ElenaLekomtseva_MobileAuto
## Exercise 4
[Project branch hw4](https://github.com/ElenaLekomtseva/ElenaLekomtseva_MobileAuto/tree/hw4)

1. Add support of appPackage and appActivity parameters for Android devices (reading from a .properties file and then setting in the DesiredCapabilities). Locally installed Appium DT has no need in these parameters, but for Appium server of Minsk Mobile Farm it’s mandatory.
<br>a.	Or try to use autoLaunch capability with app as before. Does this approach work?</br>
<br>For Mobile Farm autoLaucnh don't work. I installed app myself, sent capapbilities appActivity and appPackage for testing.</br>
2. Change settings to run web test on a certain iOS device on Mobile Test Farm. Run test with your changes. Did test pass?
<br>Instead of deviceName sent udid iOS device and passed test.</br>
3. Change settings to run native test on a certain/random Android device on Mobile Test Farm. Run test with your changes. Did test pass?
<br>Tests passed successfully on other devices.</br>
4. What’s wrong with our code? How to fix/improve it? Implement your suggestions.
<br>I transffered device parameters to testNg.xml. And run other test from testNg.xml.
Also I made capabilities and constants in enum. Used for example [the project](https://git.epam.com/epmc-tst/recipes/tree/master/appium-and-sorcery/src) from lesson.</br>
