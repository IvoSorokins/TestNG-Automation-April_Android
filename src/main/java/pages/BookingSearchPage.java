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

public class BookingSearchPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/sr_toolbar")
    private RemoteWebElement searchBar;

    @AndroidFindBy(id = "com.booking:id/searchbox_destination")
    private RemoteWebElement searchDestination;

    @AndroidFindBy(id = "com.booking:id/searchbox_dates")
    private RemoteWebElement searchDate;

    @AndroidFindBy(xpath = "//android.widget.ImageView[1]")
    private RemoteWebElement heartButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;

    public BookingSearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Booking Search page is loaded")
    public boolean bookingSearchPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchBar)).isDisplayed();
    }

    @Step("Validate if destination is '{expectedDestination}'")
    public boolean validateDestination(String expectedDestination) {
        String actualDestination = searchDestination.getText();
        return actualDestination.equals(expectedDestination);
    }
    @Step("Validate if date is '{expectedDate}'")
    public boolean validateDate(String expectedDate) {
        String actualDate = searchDate.getText();
        return actualDate.equals(expectedDate);
    }

    @Step("Clicked Save button (heart)")
    public void clickHeartButton(){heartButton.click();}

    @Step("Clicked on Back button")
    public void clickBackButton(){backButton.click();}

}
