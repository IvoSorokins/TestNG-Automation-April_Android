# TestNG Automation Project

This README file provides a description of the TestNG automation project for both iOS and Android tests.

## Android Tests:
### Test Android 1:
1. Start the **Booking** application and continue without sign in.
2. Select **Skopje** as destination.
3. Select 24 - 28 April as **date**.
4. Select 2 rooms and 3 adults.
5. Click **Search**.
6. On booking search screen validate expected destination and date is visible.
7. Click on Save button (heart) on one of the listed properties.
8. Go back to the search page.
9. Click on Saved tab.
10. Validate property is shown in Saved tab.
11. Go back to the search page.
12. Click on Sign in tab and validate that user is not logged in.
13. Scroll down to and click Settings.
14. Click Currency.
15. Change Currency to Euro.
16. Validate that Settings Currency is changed now to Euro.
17. Click on Privacy Policy and validate that Privacy and Cookies policy is open.

<br>

### Test Android 2:
1. Start the **Booking** application and continue without sign in.
2. Navigate to Sign in tab.
3. Click on Genius loyalty program.
4. Scroll down to About Genius Levels and click on it.
5. Swipe right to Genius Level 3 and validate that it is displayed.
6. Click on Got it button.
7. Click on Back button.
8. Navigate to Search tab.
9. Click on Car rental.
10. Disable Return to same location button and validate that now pickup location and drop-off location are displayed.
11. Add Skopje as Pickup location and Ohrid as Drop-off location.
12. Select 24 April to 27 April 2024 as dates.
13. Select 08:15 AM as Pickup time and 11:00 AM as Drop-off time.
14. In Driver’s age enter your age. 
15. Click search.
16. Filter cars by Automatic and validate that first displayed car is automatic.


## Utils:

### ScreenshotUtil:
- Utility class for capturing screenshots.
- Provides a method for capturing screenshots based on test status.

### TestListener
- TestNG listener class responsible for capturing screenshots on test success and failure.
- Implements ITestListener interface.

### Helpers
- Utility class containing helper methods for actions with elements.

### DriverSetup
- Utility class for setting up and tearing down the Appium Driver before and after test execution.
- Initializes the driver and performs necessary configurations.
#### Appium Capabilities
- `Platform` : Specifies the platform on which the tests will run. In this case, it's set to Android.

- `DEVICE_NAME_OPTION` : Defines the name of the device to be used for testing. This can be configured based on the device connected or the emulator being used.

- `UDID_OPTION` : Specifies the unique device identifier (UDID) of the device to be used for testing. This is particularly useful when testing on real devices.

- `AUTOMATION_NAME_OPTION` : Sets the name of the automation framework to be used. For Android, it's typically set to UiAutomator2.

- `APP_OPTION` : Specifies the path to the application (.apk) file to be installed on the device/emulator for testing.

- `APP_ACTIVITY_OPTION` : Defines the main activity of the Android application to start from. This is required to launch the application on the device.

- `APP_PACKAGE_OPTION` : Specifies the package name of the Android application. This is necessary to identify the application uniquely on the device.

- `NO_RESET_OPTION` : When set to true, it clears the app data and cache before running each test, ensuring a clean state.

- `FULL_RESET_OPTION` : When set to true, it uninstalls the existing version of the app from the device and installs the new version specified in the APP_OPTION.

- `AUTO_GRANT_PERMISSIONS_OPTION` : Automatically grants permissions requested by the app during the test execution. This is particularly useful for granting permissions like location, camera, etc., without user interaction.

- `disableIdLocatorAutocompletion` : Disables autocompletion for ID locator strategy in Appium. This can help in preventing unexpected behavior while locating elements.

- `skipDeviceInitialization` : This capability, when set to true, skips the initialization phase for the device, which can speed up test execution by avoiding unnecessary device setup steps.

### Global Variables
- Contains global variables used across the project.

### ConfigReader
- Utility class for reading configuration properties.
- Provides a method for retrieving properties from config.properties.
