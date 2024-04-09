package pages;

import components.BottomNavigationBar;
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

public class SignInPage {
    protected AndroidDriver driver;

    protected Helpers helpers;
    protected BottomNavigationBar bottomNavigationBar;

    @AndroidFindBy(id = "com.booking:id/facet_profile_header_sign_in_warning")
    private RemoteWebElement signInWarning;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign in or create account\"]")
    private RemoteWebElement signInOrCreateAccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Settings\"]")
    private RemoteWebElement settingsOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Genius loyalty program\"]")
    private RemoteWebElement geniusLoyaltySetting;

    public SignInPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers();
        this.bottomNavigationBar = new BottomNavigationBar(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Sign In page is loaded")
    public boolean signInPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInWarning)).isDisplayed();
    }

    @Step("Validate that user is not logged in, Sign in or Create account displayed")
    public boolean validateSignInOrCreateAccount(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInOrCreateAccount)).isDisplayed();
    }

    @Step("Scrolled down to Settings")
    public void swipeDownToSettings(){helpers.swipe(driver, Helpers.Directions.UP,1);}

    @Step("Clicked on Setting Option")
    public void clickSettingsOption(){settingsOption.click();}

    @Step("Clicked on Genius Loyalty Program")
    public void clickGeniusLoyaltySetting(){geniusLoyaltySetting.click();}

    @Step("Clicked Search from Sign In page")
    public void clickSearchButton(){bottomNavigationBar.getSearchButton().click();}
}
