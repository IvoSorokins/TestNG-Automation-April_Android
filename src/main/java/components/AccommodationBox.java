package components;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class AccommodationBox{
    protected AndroidDriver driver;

    // Accommodation Box Elements
    @AndroidFindBy(id = "com.booking:id/calendar_week_days")
    private RemoteWebElement accommodationCalendarWeekDays;

    @AndroidFindBy(xpath = "(//android.widget.Button)[1]")
    private RemoteWebElement firstAccommodationButton;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    private RemoteWebElement secondAccommodationButton;

    @AndroidFindBy(xpath = "(//android.widget.Button)[3]")
    private RemoteWebElement thirdAccommodationButton;

    @AndroidFindBy(xpath = "(//android.widget.Button)[4]")
    private RemoteWebElement fourthAccommodationButton;

    @AndroidFindBy(xpath = "(//android.widget.Button)[5]")
    private RemoteWebElement fifthAccommodationButton;

    @AndroidFindBy(xpath = "(//android.widget.Button)[6]")
    private RemoteWebElement sixthAccommodationButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Search\"])[1]")
    private RemoteWebElement searchButton;


    // Calendar Slider Elements
    @AndroidFindBy(accessibility = "17 April 2024")
    private RemoteWebElement calendarSeventeenApril;

    @AndroidFindBy(accessibility = "03 April 2024")
    private RemoteWebElement calendarThirdApril;

    @AndroidFindBy(accessibility = "24 April 2024")
    private RemoteWebElement calendarTwentyFourthApril;

    @AndroidFindBy(accessibility = "28 April 2024")
    private RemoteWebElement calendarTwentyEightApril;

    @AndroidFindBy(accessibility = "27 April 2024")
    private RemoteWebElement calendarTwentySeventhApril;


    public AccommodationBox(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Element Getters
    public RemoteWebElement getAccommodationCalendarWeekDays() {return accommodationCalendarWeekDays;}
    public RemoteWebElement getFirstAccommodationButton() {return firstAccommodationButton;}
    public RemoteWebElement getFourthAccommodationButton() {return fourthAccommodationButton;}
    public RemoteWebElement getThirdAccommodationButton() {return thirdAccommodationButton;}
    public RemoteWebElement getSixthAccommodationButton() {return sixthAccommodationButton;}
    public RemoteWebElement getSearchButton() {return searchButton;}
    public RemoteWebElement getCalendarSeventeenApril() {return calendarSeventeenApril;}
    public RemoteWebElement getCalendarThirdApril() {return calendarThirdApril;}
    public RemoteWebElement getCalendarTwentyFourthApril(){return calendarTwentyFourthApril;}
    public RemoteWebElement getCalendarTwentySeventhApril(){return calendarTwentySeventhApril;}
    public RemoteWebElement getCalendarTwentyEightApril(){return calendarTwentyEightApril;}

}
