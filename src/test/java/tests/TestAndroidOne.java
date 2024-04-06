package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;



@Epic("Android Tests")
@Feature("Android Test 1")
public class TestAndroidOne extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Steps include navigating through initial screens, selecting a destination, and verifying user login status")
    @Test(testName="Start the Booking application and continue without sign in")
    public void startApplicationWithoutSignInTest() {

        // 1.Start the Booking application and continue without sign in
        Assert.assertTrue(cookieSettingPage.cookieSettingPageLoaded(), "Cookie Setting page is not loaded");
        cookieSettingPage.clickAcceptButton();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign In page is loaded");
        signInPage.clickXButton();
        Assert.assertTrue(staysPage.mainPageLoaded(), "Main page is loaded");

        // 2.Select Skopje as destination
        staysPage.clickDestinationButton();
        Assert.assertTrue(destinationSearchPage.destinationSearchPageLoaded(), "Destination Search page is loaded");
        destinationSearchPage.enterDestination("Skopje");
        destinationSearchPage.selectDestination("Skopje");

        // 3.Select 24 - 28 April as date
        staysPage.clickDateButton();
        staysPage.clickOnCalendarTwentyFourthApril();
        staysPage.clickOnCalendarTwentyEightApril();
        staysPage.clickOnCalendarSelectDatesButton();


    }
}
