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


public class GeniusLoyaltyPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Sign up – it's free\"])[2]")
    private RemoteWebElement signUpButton;

    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    private RemoteWebElement aboutGeniusLevels;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;


    public GeniusLoyaltyPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Step("Genius Loyalty page is loaded")
    public boolean geniusLoyaltyPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signUpButton)).isDisplayed();
    }
    @Step("Returned to Genius Loyalty page")
    public boolean returnedGeniusLoyaltyPage(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(aboutGeniusLevels)).isDisplayed();
    }

    @Step("Clicked Genius Levels")
    public void clickedGeniusLevel(){aboutGeniusLevels.click();}

    @Step("Swiped Genius Level into view")
    public void swipeGeniusLevelIntoView() {swipe(driver, Directions.UP,3);}

    @Step("Clicked Back")
    public void clickBackButton(){backButton.click();}

}
