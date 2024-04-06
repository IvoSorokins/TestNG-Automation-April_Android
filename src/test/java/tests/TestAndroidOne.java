package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;
import utils.Helpers;


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
        Assert.assertTrue(welcomePage.welcomePageLoaded(), "Welcome page is not loaded");
        welcomePage.clickXButton();
        Assert.assertTrue(mainSearchPage.mainSearchPageLoaded(), "Main Search page is not loaded");

        // 2.Select Skopje as destination
        mainSearchPage.clickDestinationButton();
        Assert.assertTrue(destinationSearchPage.destinationSearchPageLoaded(), "Destination Search page is not loaded");
        destinationSearchPage.enterDestination("Skopje");
        destinationSearchPage.selectDestination("Skopje");
        Assert.assertTrue(mainSearchPage.mainSearchPageWithSliderLoaded(), "Main Search page with slider is not loaded");

        // 3.Select 24 - 28 April as date
        mainSearchPage.scrolledDownCalendar();
        mainSearchPage.clickOnCalendarTwentyFourthApril();
        mainSearchPage.clickOnCalendarTwentyEightApril();
        mainSearchPage.clickOnCalendarSelectDatesButton();

        // 4.Select 2 rooms and 3 adults
        mainSearchPage.clickRoomPeopleButton();
        mainSearchPage.clickIncreaseRooms();
        mainSearchPage.clickIncreaseAdults();
        mainSearchPage.clickApplyButton();

        // 5.Click Search
        mainSearchPage.clickSearchButton();
        Assert.assertTrue(bookingSearchPage.bookingSearchPageLoaded(), "Booking Search page is not loaded");


        // 6.On booking search screen validate expected destination and date is visible
        Assert.assertTrue(bookingSearchPage.validateDestination("Skopje"), "Destination is not as expected");
        Assert.assertTrue(bookingSearchPage.validateDate("Apr 24 - Apr 28"), "Date is not as expected");

        // 7.Click on Save button (heart) on one of the listed property
        bookingSearchPage.clickHeartButton();

        // 8.Go back to the search page
        bookingSearchPage.clickBackButton();
        Assert.assertTrue(mainSearchPage.mainSearchPageLoaded(), "Main Search page is not loaded");

        // 9.Click on Saved tab
        bottomNavigationBar.clickSavedButton();

        // 10. Validate property is shown in Saved tab.
        savedPage.savedPageLoaded(); // Also Validates that Title is visible, page not empty
        Assert.assertTrue(savedPage.propertyImageShown()&&savedPage.propertyCardShown(),"Property is not loaded on Saved Page");

        // 11. Go back to the search page.
        savedPage.clickBack();
        bottomNavigationBar.clickSearchButton();
        Assert.assertTrue(mainSearchPage.mainSearchPageLoaded(), "Main Search page is not loaded");

        // 12. Click on Sign in tab and validate that user is not logged in.
        bottomNavigationBar.clickSignInButton();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign In page is not loaded");
        Assert.assertTrue(signInPage.validateSignInOrCreateAccount(), "User is not Sign Out");

        // 13. Scroll down to and click Settings.
        helpers.swipeVertically(driver, Helpers.Directions.UP);
        signInPage.clickSettingsOption();
        Assert.assertTrue(settingsPage.settingsPageLoaded(), "Settings page is not loaded");

        // 14. Click Currency.
        settingsPage.clickCurrency();
        Assert.assertTrue(currencyPage.currencyPageLoaded(), "Currency page is not loaded");


        // 15. Change Currency to Euro.

        // 16. Validate that Settings Currency is changed now to Euro.
        // 17. Click on Privacy Policy and validate that Privacy and Cookies policy is open.
    }
}
