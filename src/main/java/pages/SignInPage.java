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

public class SignInPage {
    protected AndroidDriver driver;

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

    @Step("Clicked on Setting Option")
    public void clickSettingsOption(){clickSettingsOption();}

    @Step("Clicked on Genius Loyalty Program")
    public void clickGeniusLoyaltySetting(){geniusLoyaltySetting.click();}
}
