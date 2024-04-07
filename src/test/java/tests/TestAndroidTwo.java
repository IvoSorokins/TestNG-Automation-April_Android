package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;


@Epic("Android Tests")
@Feature("Android Test 1")
public class TestAndroidTwo extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Genius Levels, Car rental and it's settings functionality")
    @Test(testName="AndroidTwo")
    public void testTwo(){

        Assert.assertTrue(cookieSettingPage.cookieSettingPageLoaded(), "Cookie Setting page is not loaded");
    }
}
