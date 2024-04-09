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

public class SavedPage {
    protected AndroidDriver driver;
    protected BottomNavigationBar bottomNavigationBar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Share, compare, and book your favorite properties on any device.\"]")
    private RemoteWebElement savedDescription;

    public SavedPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        this.bottomNavigationBar = new BottomNavigationBar(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Saved Page is loaded")
    public boolean savedPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(savedDescription)).isDisplayed();
    }
    @Step("Clicked 'Search' while on 'Saved' page")
    public void clickSearchButton(){bottomNavigationBar.getSearchButton().click();}
}
