package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverSetup;


@Epic("Android Tests")
@Feature("Android Test 2")
public class TestAndroidTwo extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Genius Levels, Car rental and it's settings functionality")
    @Test(testName="AndroidTwo")
    public void testTwo(){

//      1. Start the **Booking** application and continue without sign in.
        Assert.assertTrue(cookieSettingPage.cookieSettingPageLoaded(), "Cookie Setting page is not loaded");
        cookieSettingPage.clickAcceptButton();
        Assert.assertTrue(welcomePage.welcomePageLoaded(), "Welcome page is not loaded");
        welcomePage.clickXButton();
        Assert.assertTrue(staysPage.staysPageLoaded(), "Stays page is not loaded");

////      2. Navigate to Sign in tab.
//        staysPage.clickSignInButton();
//        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign In page is not loaded");
//
////      3. Click on Genius loyalty program.
//        signInPage.clickGeniusLoyaltySetting();
//        Assert.assertTrue(geniusLoyaltyPage.geniusLoyaltyPageLoaded(),"Genius Loyalty Page is not loaded");
//
////      4. Scroll down to About Genius Levels and click on it.
//        geniusLoyaltyPage.swipeGeniusLevelIntoView();
//        geniusLoyaltyPage.clickedGeniusLevel();
//        Assert.assertTrue(geniusLevelPage.geniusLoyaltyPageLoaded(),"Genius Level Page is not loaded");
//
////      5. Swipe right to Genius Level 3 and validate that it is displayed.
//        geniusLevelPage.swipeToGeniusLevel3();
//
//
////      6. Click on Got it button.
//        geniusLevelPage.clickGotItButton();
//        Assert.assertTrue(geniusLoyaltyPage.returnedGeniusLoyaltyPage(),"Sign In is not loaded");
//
////      7. Click on Back button.
//        geniusLoyaltyPage.clickBackButton();
//        Assert.assertTrue(signInPage.signInPageLoaded(),"Sign In is not loaded");

//      8. Navigate to Search tab.
        signInPage.clickSearchButton();
        Assert.assertTrue(staysPage.staysPageLoaded(),"Car Rental Page is not loaded");

//      9. Click on Car rental.
        staysPage.clickCarRentalOption();
        Assert.assertTrue(carRentalPage.carRentalPageLoaded(),"Car Rental Page is not loaded");

//      10. Disable Return to same location button and validate that now pickup location and drop-off location are displayed.
        carRentalPage.clickReturnToSameLocation();
        Assert.assertTrue(carRentalPage.pickUpButtonLoaded(),"Pick Up Button is not loaded");
        Assert.assertTrue(carRentalPage.dropOffLoaded(),"Drop Off Button is not loaded");

//      11. Add Skopje as Pickup location and Ohrid as Drop-off location.
        carRentalPage.clickPickUpButton();
        Assert.assertTrue(carPickDropSearchPage.carPickDropSearchPageLoaded(),"Car Pickup and Drop Off Location Page is not laoded");
        carPickDropSearchPage.enterPickUpLocation("Skopje");
        carPickDropSearchPage.clickSecondSearchResult();
        Assert.assertTrue(carRentalPage.carRentalPageLoaded(),"Car Rental Page is not loaded");

        carRentalPage.clickDropOffButton();
        carPickDropSearchPage.enterDropOffLocation("Ohrid");
        carPickDropSearchPage.clickSecondSearchResult();
        Assert.assertTrue(carRentalPage.carRentalPageLoaded(),"Car Rental Page is not loaded");

//      12. Select 24 April to 27 April 2024 as dates.
        carRentalPage.clickAccommodationDateButton();
        carRentalPage.swipeDownCalendar();
        carRentalPage.clickTwentyFourthApril();
        carRentalPage.clickTwentySeventhApril();
        carRentalPage.clickSelectDates();


//      13. Select 08:15 AM as Pickup time and 11:00 AM as Drop-off time.
        carRentalPage.clickPickUpTimeButton();
        carRentalPage.swipeToPickUpTime();
        carRentalPage.clickPickUpTime();

        carRentalPage.clickDropOffTimeButton();
        carRentalPage.clickDropOffTime();

//      14. In Driver’s age enter your age.
        carRentalPage.enterDriversAge();

//      15. Click search.
        carRentalPage.clickSearch();
        Assert.assertTrue(carRentalSearchPage.carRentalSearchPageLoaded(),"Car Rental Search Page is not loaded");


//      16. Filter cars by Automatic and validate that first displayed car is automatic.
        carRentalSearchPage.clickFilterButton();
        carFilterPage.scrollToAutomaticFilter();
        Assert.assertTrue(carFilterPage.carFilterPageLoaded(),"Car Rental Page is not loaded");
        carFilterPage.clickAutomaticFilter();
        carFilterPage.clickShowResults();
        Assert.assertTrue(carRentalSearchPage.carRentalSearchPageLoaded(),"Car Rental Search Page is not loaded");
        carRentalSearchPage.verifyFilterResults();
    }
}
