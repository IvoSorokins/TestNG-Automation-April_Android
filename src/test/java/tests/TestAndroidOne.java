package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;


@Epic("Android Tests")
@Feature("Android Test 1")
public class TestAndroidOne extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user login status and perform actions with properties, including navigating through initial screens and selecting a destination")
    @Test(testName="AndroidOne")
    public void testOne() {

        // 1.Start the Booking application and continue without sign in
        Assert.assertTrue(cookieSettingPage.cookieSettingPageLoaded(), "Cookie Setting page is not loaded");
        cookieSettingPage.clickAcceptButton();
        Assert.assertTrue(welcomePage.welcomePageLoaded(), "Welcome page is not loaded");
        welcomePage.clickXButton();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

        // 2.Select Skopje as destination
        staysPage.clickFirstAccommodationButton();
        Assert.assertTrue(destinationSearchPage.destinationSearchPageLoaded(), "Destination Search page is not loaded");
        destinationSearchPage.enterDestination("Skopje");
        destinationSearchPage.selectDestination("Skopje");
        Assert.assertTrue(staysPage.staysPageWithSliderLoaded(), "Stays page with slider is not loaded");

        // 3.Select 24 - 28 April as date
        staysPage.scrolledDownCalendar();
        staysPage.clickOnCalendarTwentyFourthApril();
        staysPage.clickOnCalendarTwentyEightApril();
        staysPage.clickOnCalendarSelectDatesButton();

        // 4.Select 2 rooms and 3 adults
        staysPage.clickRoomPeopleButton();
        staysPage.clickIncreaseRooms();
        staysPage.clickIncreaseAdults();
        staysPage.clickApplyButton();

        // 5.Click Search
        staysPage.clickSearchButton();
        Assert.assertTrue(bookingSearchPage.bookingSearchPageLoaded(), "Booking Search page is not loaded");

        // 6.On booking search screen validate expected destination and date is visible
        Assert.assertTrue(bookingSearchPage.validateDestination("Skopje"), "Destination is not as expected");
        Assert.assertTrue(bookingSearchPage.validateDate("Apr 24 - Apr 28"), "Date is not as expected");

        // 7.Click on Save button (heart) on one of the listed property
        bookingSearchPage.clickHeartButton();

        // 8.Go back to the search page
        bookingSearchPage.clickBackButton();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

        // 9.Click on Saved tab
        staysPage.clickSavedButton();

        // 10. Validate property is shown in Saved tab.
        myNextTripPage.myNextTripPageLoaded(); // Also Validates that Title is visible, page not empty
        Assert.assertTrue(myNextTripPage.propertyImageShown()&& myNextTripPage.propertyCardShown(),"Property page is not loaded on Saved Page");

        // 11. Go back to the search page.
        myNextTripPage.clickBack();
        Assert.assertTrue(savedPage.savedPageLoaded(),"Stays page is not loaded");
        savedPage.clickSearchButton();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

        // 12. Click on Sign in tab and validate that user is not logged in.
        staysPage.clickSignInButton();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign In page is not loaded");
        Assert.assertTrue(signInPage.validateSignInOrCreateAccount(), "User is not Sign Out");

        // 13. Scroll down to and click Settings.
        signInPage.swipeDownToSettings();
        signInPage.clickSettingsOption();
        Assert.assertTrue(settingsPage.settingsPageLoaded(), "Settings page is not loaded");

        // 14. Click Currency.
        settingsPage.clickCurrency();
        Assert.assertTrue(currencyPage.currencyPageLoaded(), "Currency page is not loaded");

        // 15. Change Currency to Euro.
        currencyPage.clickEuro();
        Assert.assertTrue(settingsPage.settingsPageLoaded(), "Settings page is not loaded");

        // 16. Validate that Settings Currency is changed now to Euro.
        Assert.assertTrue(settingsPage.settingsPageLoaded(), "Settings page is not loaded");
        Assert.assertEquals(settingsPage.getCurrency(),"Euro (€)","Setting is not changed correctly");

        // 17. Click on Privacy Policy and validate that Privacy and Cookies policy is open.
        settingsPage.clickPrivacyPolicySetting();
        Assert.assertTrue(privacyPolicyPage.privacyPolicyPageLoaded(),"Privacy Policy and Cookies policy page is not loaded");
    }
}
