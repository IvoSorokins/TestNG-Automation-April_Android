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

public class CarRentalSearchPage {
    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "(//android.view.View[2]/android.widget.Button)[2]")
    private RemoteWebElement filterButton;

    @AndroidFindBy(accessibility = "Automatic gearbox")
    private RemoteWebElement searchResultGearBox;

    public CarRentalSearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Car Rental Search  page is loaded")
    public boolean carRentalSearchPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(filterButton)).isDisplayed();
    }

    @Step("Click Filter Button")
    public void clickFilterButton(){filterButton.click();}

    @Step("Verified Gearbox Automatic")
    public void verifyFilterResults(){searchResultGearBox.isDisplayed();}

}
