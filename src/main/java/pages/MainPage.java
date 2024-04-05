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

public class MainPage {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Accommodation search box")
    private RemoteWebElement accommodationBox;

    @AndroidFindBy(accessibility = "Enter your destination")
    private RemoteWebElement destinationButton;

    public MainPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Main Page is loaded")
    public boolean mainPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(accommodationBox)).isDisplayed();
    }

    @Step("Click on 'Enter your destination'")
    public void clickDestinationButton(){destinationButton.click();}

}
