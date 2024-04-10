package pages;

import components.AccommodationBox;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;
import utils.Helpers;

public class CarRentalPage {
    protected AndroidDriver driver;
    protected Helpers helpers;
    protected AccommodationBox accommodationBox;

    @AndroidFindBy(accessibility = "Car rental search box")
    private RemoteWebElement accommodationBoxWidget;

    @AndroidFindBy(accessibility = "Enter a pick-up location")
    private RemoteWebElement pickUpButton;

    @AndroidFindBy(accessibility = "Enter a drop-off location")
    private RemoteWebElement dropOffButton;

    @AndroidFindBy(accessibility = "Selected, you will return the car to the same location")
    private RemoteWebElement returnSameLocation;

    @AndroidFindBy(id = "com.booking:id/calendar_confirm")
    private RemoteWebElement selectDatesButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"8:15 AM\"]")
    private RemoteWebElement pickUpTimeElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"11:00 AM\"]")
    private RemoteWebElement dropOffTimeElement;

    @AndroidFindBy(accessibility = "Enter the driver's age")
    private RemoteWebElement driversAgeButton;


    public CarRentalPage(AndroidDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers();
        this.accommodationBox = new AccommodationBox(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Car Rental Page is loaded")
    public boolean carRentalPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(accommodationBoxWidget)).isDisplayed();
    }

    @Step("Clicked Return to Same Location")
    public void clickReturnToSameLocation(){returnSameLocation.click();}

    @Step("Pick Up Button is loaded")
    public boolean pickUpButtonLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(pickUpButton)).isDisplayed();
    }

    @Step("Drop Off is loaded")
    public boolean dropOffLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(dropOffButton)).isDisplayed();
    }

    @Step("Clicked Pick Up button")
    public void clickPickUpButton(){pickUpButton.click();}

    @Step("Clicked Drop Off button")
    public void clickDropOffButton(){dropOffButton.click();}

    @Step("Clicked Accommodation Box Date button")
    public void clickAccommodationDateButton(){accommodationBox.getThirdAccommodationButton().click();}

    @Step("Swiped down Calendar")
    public void swipeDownCalendar(){helpers.scrollFromElementToElement(driver,
            accommodationBox.getCalendarSeventeenApril(),
            accommodationBox.getCalendarThirdApril());}

    @Step("Clicked on 24th April")
    public void clickTwentyFourthApril(){accommodationBox.getCalendarTwentyFourthApril().click();}

    @Step("Clicked on 27th April")
    public void clickTwentySeventhApril(){accommodationBox.getCalendarTwentySeventhApril().click();}

    @Step("Clicked Select dates")
    public void clickSelectDates(){selectDatesButton.click();}

    @Step("Scrolled to 8:15 AM time")
    public void swipeToPickUpTime(){
        helpers.wait(1);
        helpers.swipe(driver, Helpers.Directions.DOWN,1);
    }
    @Step("Clicked 8:15 AM")
    public void clickPickUpTime(){pickUpTimeElement.click();}

    @Step("Clicked Pick Up Time Button on Accommodation Box")
    public void clickPickUpTimeButton(){accommodationBox.getFourthAccommodationButton().click();}

    @Step("Clicked Drop Off Time Button on Accommodation Box")
    public void clickDropOffTimeButton(){accommodationBox.getSixthAccommodationButton().click();}

    @Step("Clicked 11:00 AM")
    public void clickDropOffTime(){dropOffTimeElement.click();}

    @Step("Entered Drivers Age")
    public void enterDriversAge() {
        driversAgeButton.click();
        helpers.wait(2);

        // Tap on the coordinates of number "2" twice
        tapOnCoordinates(420, 1250);
        tapOnCoordinates(420, 1250); // Update coordinates according to your UI

        // Tap on the coordinates of "Done"
        tapOnCoordinates(940, 1730); // Update coordinates according to your UI

        helpers.wait(1); // Added wait because keyboard might sometimes get in a way because of device being slow
    }
    private void tapOnCoordinates(int x, int y) {
        new TouchAction(driver)
                .tap(PointOption.point(x, y))
                .perform();
    }

    @Step("Clicked Search")
    public void clickSearch(){
        accommodationBox.getSearchButton().click();}

}
