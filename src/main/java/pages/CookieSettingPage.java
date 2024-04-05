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


public class CookieSettingPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/gdpr_consent_heading")
    private RemoteWebElement cookieTitle;

    @AndroidFindBy(id = "com.booking:id/bt_accept")
    private RemoteWebElement acceptButton;

    public CookieSettingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("New Cookie Setting page is loaded")
    public boolean cookieSettingPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(cookieTitle)).isDisplayed();
    }

    @Step("Click on the Accept button to confirm cookie settings")
    public void clickAcceptButton(){acceptButton.click();}

}
