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

public class CarFilterPage {
    protected AndroidDriver driver;
    protected Helpers helpers;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Automatic\"]")
    private RemoteWebElement automaticFilter;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Filter by']")
    private RemoteWebElement filterByTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Show results\"]")
    private RemoteWebElement showResultsButton;

    public CarFilterPage(AndroidDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Car Rental Search  page is loaded")
    public boolean carFilterPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(filterByTitle)).isDisplayed();
    }

    @Step("Scrolled to Automatic Filter")
    public void scrollToAutomaticFilter(){
        helpers.swipe(driver, Helpers.Directions.UP,1);
    }
    @Step("Clicked Automatic Filter")
    public void clickAutomaticFilter(){
        automaticFilter.click();}

    @Step("Clicked Show results")
    public void clickShowResults(){showResultsButton.click();}
}
