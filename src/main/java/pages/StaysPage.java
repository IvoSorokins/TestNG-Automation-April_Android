package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVariables;

public class StaysPage {

    protected AndroidDriver driver;

    // Accommodation Box Elements
    @AndroidFindBy(accessibility = "Accommodation search box")
    private RemoteWebElement accommodationBox;

    @AndroidFindBy(xpath = "(//android.widget.Button)[1]\n")
    private RemoteWebElement destinationButton;

    @AndroidFindBy(xpath = "//android.widget.Button[3]")
    private RemoteWebElement roomPeopleButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Search\"])[1]")
    private RemoteWebElement searchButton;


    // Calendar Slider Elements
    @AndroidFindBy(accessibility = "24 April 2024")
    private RemoteWebElement calendarTwentyFourthApril;

    @AndroidFindBy(accessibility = "28 April 2024")
    private RemoteWebElement calendarTwentyEightApril;

    @AndroidFindBy(id = "com.booking:id/facet_date_picker_confirm")
    private RemoteWebElement calendarSelectDatesButton;


    // Rooms Slider Elements
    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Increase\"])[1]")
    private RemoteWebElement increaseRooms;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Increase\"])[2]")
    private RemoteWebElement increaseAdults;

    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private RemoteWebElement applyButton;


    public StaysPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Stays Page is loaded")
    public boolean mainPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(accommodationBox)).isDisplayed();
    }

    // Actions with Accommodation Box Elements
    @Step("Click on 'Enter your destination' on Accommodation Box")
    public void clickDestinationButton(){destinationButton.click();}


    @Step("Clicked on Room and People Button on Accommodation Box")
    public void clickRoomPeopleButton(){roomPeopleButton.click();}

    @Step("Clicked on Search on Accommodation Box")
    public void clickSearchButton(){searchButton.click();}


    // Actions with Date Slider
    @Step("Clicked on 24th April")
    public void clickOnCalendarTwentyFourthApril(){calendarTwentyFourthApril.click();}

    @Step("Clicked on 28th April")
    public void clickOnCalendarTwentyEightApril(){calendarTwentyEightApril.click();}

    @Step("Clicked on 24th April ")
    public void clickOnCalendarSelectDatesButton(){calendarSelectDatesButton.click();}


    // Actions with Room and People Slider
    @Step("Clicked on '+' to increased Room count")
    public void clickIncreaseRooms() {increaseRooms.click();}
    @Step("Clicked on '+' Increased Adult Count")
    public void clickIncreaseAdults () {increaseAdults.click();}
    @Step("Clicked on Apply Button")
    public void clickApplyButton () {applyButton.click();}

}

