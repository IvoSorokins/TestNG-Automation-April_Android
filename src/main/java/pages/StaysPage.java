package pages;

import components.AccommodationBox;
import components.BottomNavigationBar;
import components.TopNavigationBar;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;
import utils.Helpers;

public class StaysPage extends Helpers {
    protected AndroidDriver driver;

    // Components
    protected AccommodationBox accommodationBox;
    protected BottomNavigationBar bottomNavigationBar;
    protected TopNavigationBar topNavigationBar;

    @AndroidFindBy(accessibility = "Accommodation search box")
    private RemoteWebElement accommodationBoxElement;

    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private RemoteWebElement applyButton;

    // Rooms Slider Elements
    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Increase\"])[1]")
    private RemoteWebElement increaseRooms;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Increase\"])[2]")
    private RemoteWebElement increaseAdults;

    @AndroidFindBy(id = "com.booking:id/facet_date_picker_confirm")
    private RemoteWebElement calendarSelectDatesButton;


    public StaysPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        this.accommodationBox = new AccommodationBox(driver);
        this.bottomNavigationBar = new BottomNavigationBar(driver);
        this.topNavigationBar = new TopNavigationBar(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Page Loading Actions
    @Step("Stays Page is loaded")
    public boolean staysPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(accommodationBoxElement)).isDisplayed();
    }
    @Step("Stays Page with slider is loaded")
    public boolean mainSearchPageWithSliderLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(accommodationBox.getAccommodationCalendarWeekDays())).isDisplayed();
    }

    // Actions with Accommodation Box Elements
    @Step("Click on 'Enter your destination' on Accommodation Box")
    public void clickFirstAccommodationButton(){accommodationBox.getFirstAccommodationButton().click();}


    @Step("Clicked on Room and People Button on Accommodation Box")
    public void clickRoomPeopleButton(){
        accommodationBox.getThirdAccommodationButton().click();}

    @Step("Clicked Search on Accommodation Box")
    public void clickSearchButton(){accommodationBox.getSearchButton().click();}


    // Actions with Date Slider
    @Step("Scrolled down Calendar")
    public void scrolledDownCalendar(){
        scrollFromElementToElement(driver,
                accommodationBox.getCalendarSeventeenApril(),
                accommodationBox.getCalendarThirdApril());
    }

    @Step("Clicked on 24th April")
    public void clickOnCalendarTwentyFourthApril(){accommodationBox.getCalendarTwentyFourthApril().click();}

    @Step("Clicked on 28th April")
    public void clickOnCalendarTwentyEightApril(){accommodationBox.getCalendarTwentyEightApril().click();}

    @Step("Clicked on Select Dates")
    public void clickOnCalendarSelectDatesButton(){calendarSelectDatesButton.click();}


    // Actions with Room and People Slider
    @Step("Clicked on '+' to increased Room count")
    public void clickIncreaseRooms() {increaseRooms.click();}
    @Step("Clicked on '+' Increased Adult Count")
    public void clickIncreaseAdults () {increaseAdults.click();}
    @Step("Clicked on Apply Button")
    public void clickApplyButton () {applyButton.click();}


    // Actions with Car Rental
    @Step("Clicked Car Rental from Top Navigation Bar")
    public void clickCarRentalOption(){
        topNavigationBar.getCarRentalOption().click();}

    // Actions with Bottom Navigation Bar
    @Step("CLicked Saved from Stays page")
    public void clickSavedButton(){bottomNavigationBar.getSavedButton().click();}

    @Step("Clicked Sign In from Stays page")
    public void clickSignInButton(){bottomNavigationBar.getSignInButton().click();}


}