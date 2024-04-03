package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;

public class TestAndroidOne extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Covering Test case for Android One scenarios")
    @Test(testName="AndroidOne")
    public void testAndroidOne(){

        Assert.assertTrue(cookieSettingPage.cookieSettingPageLoaded(), "Cookie Setting page is not loaded");
    }
}
