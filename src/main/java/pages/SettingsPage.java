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


public class SettingsPage {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Device settings\"]")
    private RemoteWebElement settingsTitle;

    @AndroidFindBy(xpath = "(//android.view.View[1]/android.view.View[2])[1]")
    private RemoteWebElement currencySetting;

    @AndroidFindBy(xpath = "//android.view.View[9]")
    private RemoteWebElement privacyPolicySetting;


    public SettingsPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Step("Settings Page is loaded")
    public boolean settingsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(settingsTitle)).isDisplayed();
    }

    @Step("Clicked on Currency")
    public void clickCurrency(){currencySetting.click();}

    @Step("Validate Settings Currency is changed now to Euro")
    public String getCurrency(){
       return currencySetting.getText();
    }

    @Step("Clicked on Privacy Policy")
    public void clickPrivacyPolicySetting(){privacyPolicySetting.click();}
}
