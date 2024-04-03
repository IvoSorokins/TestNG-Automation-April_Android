package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;

import io.qameta.allure.Step;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import pages.CookieSettingPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;


import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static utils.GlobalVariables.globalTimeout;

/**
 * Utility class for setting up the Appium driver
 */
public class DriverSetup extends ConfigReader {

    /**
     * The instance of the Appium driver
     */
    public static AndroidDriver driver;

    protected CookieSettingPage cookieSettingPage;

    /**
     * Sets up the Appium driver before each test method
     */
    @Step("Driver is started")
    @BeforeMethod
    public void setUp() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(UiAutomator2Options.DEVICE_NAME_OPTION, getProperty("device.name"));
        capabilities.setCapability(UiAutomator2Options.UDID_OPTION, getProperty("device.udid"));
        capabilities.setCapability(UiAutomator2Options.AUTOMATION_NAME_OPTION, getProperty("automation.name"));
        capabilities.setCapability(UiAutomator2Options.APP_OPTION, getProperty("path.to.app"));
        capabilities.setCapability(UiAutomator2Options.APP_ACTIVITY_OPTION, getProperty("app.activity"));
        capabilities.setCapability(UiAutomator2Options.APP_PACKAGE_OPTION, getProperty("app.package"));
        capabilities.setCapability(UiAutomator2Options.NO_RESET_OPTION, false);
        capabilities.setCapability(UiAutomator2Options.FULL_RESET_OPTION, true);
        capabilities.setCapability(UiAutomator2Options.AUTO_GRANT_PERMISSIONS_OPTION, true);
        capabilities.setCapability("appium:disableIdLocatorAutocompletion", true);
        capabilities.setCapability(UiAutomator2Options.AUTO_GRANT_PERMISSIONS_OPTION, true);

        try {
            driver = new AndroidDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), capabilities);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        
        // Wait for specified amount of time when trying to find element
        driver.manage().timeouts().implicitlyWait(globalTimeout);

        // Initialize Pages here
        cookieSettingPage = new CookieSettingPage(driver);
    }

    /**
     * Tears down the Appium driver after each test method
     */
    @Step("Driver is closed")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
