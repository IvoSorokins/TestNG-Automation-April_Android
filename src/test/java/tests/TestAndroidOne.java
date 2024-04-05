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

        cookieSettingPage.clickAcceptButton();

        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign In page is loaded");

        signInPage.clickXButton();

        Assert.assertTrue(mainPage.mainPageLoaded(), "Main page is loaded");

        mainPage.clickDestinationButton();

        Assert.assertTrue(destinationSearchPage.destinationSearchPageLoaded(), "Destination Search page is loaded");

        destinationSearchPage.enterDestination("Skopje");

        destinationSearchPage.clickSearchResults();

        Assert.assertTrue(selectDatePage.mainPageLoaded(),"Select Dates page is loaded");



    }
}
