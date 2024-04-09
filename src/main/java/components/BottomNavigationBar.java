package components;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class BottomNavigationBar {
    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Search")
    private RemoteWebElement searchButton;

    @AndroidFindBy(accessibility = "Saved")
    private RemoteWebElement savedButton;

    @AndroidFindBy(accessibility = "Bookings")
    private RemoteWebElement bookingsButton;

    @AndroidFindBy(accessibility = "Sign in")
    private RemoteWebElement signInButton;

    public BottomNavigationBar(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Element Getters
    public RemoteWebElement getSearchButton() {return searchButton;}
    public RemoteWebElement getSavedButton() {return savedButton;}
    public RemoteWebElement getBookingsButton() {return bookingsButton;}
    public RemoteWebElement getSignInButton() {return signInButton;}
}

