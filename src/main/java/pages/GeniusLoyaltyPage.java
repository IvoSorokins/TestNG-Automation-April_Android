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
import utils.Helpers;


public class GeniusLoyaltyPage {

    protected AndroidDriver driver;
    protected Helpers helpers;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Booking.com is better with Genius\"]")
    private RemoteWebElement geniusTitle;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    private RemoteWebElement aboutGeniusLevels;
    public GeniusLoyaltyPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Destination Search page is loaded")
    public boolean geniusLoyaltyPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(geniusTitle)).isDisplayed();
    }

    @Step("Clicked Genius Levels")
    public void clickedGeniusLevel(){aboutGeniusLevels.click();}

    @Step("Swiped Genius Level into view")
    public void swipeGeniusLevelIntoView() {
        helpers.swipeVertically(driver, Helpers.Directions.UP,7);
    }
}