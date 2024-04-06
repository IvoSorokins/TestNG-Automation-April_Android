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

public class SavedPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"My next trip\"])[1]")
    private RemoteWebElement myNextTripTitle;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView//android.view.View[4]")
    private RemoteWebElement firstSavedPropertyImage;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView//android.view.View[5]")
    private RemoteWebElement firstSavedPropertyCard;

    public SavedPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Saved Page is loaded")
    public boolean savedPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(myNextTripTitle)).isDisplayed();
    }
    @Step("Validated property Image is shown in Saved tab")
    public boolean propertyImageShown() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(firstSavedPropertyImage)).isDisplayed();
    }

    @Step("Validated property Card is shown in Saved tab")
    public boolean propertyCardShown() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(firstSavedPropertyCard)).isDisplayed();
    }


}
