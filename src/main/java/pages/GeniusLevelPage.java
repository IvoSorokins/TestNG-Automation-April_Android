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


public class GeniusLevelPage {

    protected AndroidDriver driver;

    protected Helpers helpers;

    @AndroidFindBy(id = "com.booking:id/genius_levels_title")
    private RemoteWebElement geniusLevelTitle;

    @AndroidFindBy(id = "com.booking:id/action_button")
    private RemoteWebElement gotItButton;

    public GeniusLevelPage (io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Step("Destination Search page is loaded")
    public boolean geniusLoyaltyPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(geniusLevelTitle)).isDisplayed();
    }
    @Step("Swiped to Genius Level 3")
    public void swipeToGeniusLevel3() {helpers.swipe(driver, Helpers.Directions.LEFT,2);}

    @Step("Clicked 'Got It'")
    public void clickGotItButton(){gotItButton.click();}
}
