1.	Change settings to run web test on a certain iOS device on Mobile Test Farm. Run test with your changes. 
Did test pass?

No. In connection with fact that some commands didn`t work correct on different platforms
(ex: getDriver().navigate().back())

2.	Change settings to run native test on a certain/random Android device on Mobile Test Farm. 
Run test with your changes. Did test pass?

If before the test our app was installed on chosen device, we will have a positive result of testing, but it will be
negative if we try to run it on random device.
I have thought that I can change situation with addition to before class smth like:
” if (getDriver() != null && getDriver().isAppInstalled(getApp())){
            getDriver().installApp(getApp());}” 
It was interesting idea but it failed! So, I see only one way: 
preliminary installing. I believe the developers will fix it in the some next patches & sometimes we 
will have an opportunity to run our tests on the random Android devices

3.	What’s wrong with our code? How to fix/improve it? Implement your suggestions.

- We need to use that commands, which can be executed by the both platforms
- I replace line “getDriver().navigate().back()”(which didn't work on iPhones) 
with “getDriver().get(HOME.text)”;
- I add new parameters to the .properties(native – appPackage, appActivity; udid for every farm`s devices)