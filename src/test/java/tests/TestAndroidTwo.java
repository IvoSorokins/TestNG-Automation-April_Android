package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;

public class TestAndroidTwo extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Covering Test case for Android Two scenarios")
    @Test(testName="AndroidTwo")
    public void testAndroidTwo(){

        Assert.assertTrue(cookieSettingPage.cookieSettingPageLoaded(), "Cookie Setting page is not loaded");
    }
}
