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

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement xbutton;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Sign in for easier access to your trip details\"]")
    private RemoteWebElement signInTitle;


    public SignInPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Sign In page is loaded")
    public boolean signInPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInTitle)).isDisplayed();
    }

    @Step("Click on X Button to continue without sign in")
    public void clickXButton(){xbutton.click();}
}
