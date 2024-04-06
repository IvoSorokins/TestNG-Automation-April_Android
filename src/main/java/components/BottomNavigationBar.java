package components;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
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

    @Step("Clicked Search Button")
    public void clickSearchButton(){searchButton.click();}

    @Step("Clicked Saved Button")
    public void clickSavedButton(){savedButton.click();}

    @Step("Clicked Bookings Button")
    public void clickBookingsButton(){bookingsButton.click();}

    @Step("Clicked Sign In Button")
    public void clickSignInButton(){signInButton.click();}
}
