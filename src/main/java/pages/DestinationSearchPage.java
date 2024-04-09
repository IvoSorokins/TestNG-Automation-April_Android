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

import java.util.List;

public class DestinationSearchPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/facet_with_bui_free_search_booking_header_toolbar")
    private RemoteWebElement headerSearchBar;

    @AndroidFindBy(id = "com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content")
    private RemoteWebElement headerSearchBarTextBox;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.TextView")
    private List<RemoteWebElement> searchResults;


    public DestinationSearchPage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Step("Destination Search page is loaded")
    public boolean destinationSearchPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(headerSearchBar)).isDisplayed();
    }

    @Step("Entered specified destination: '{destination}' ")
    public void enterDestination(String destination) {
        headerSearchBarTextBox.sendKeys(destination);
    }

    @Step("Tapped on the result with the specified destination: '{destination}'")
    public void selectDestination(String destination) {
        // Iterate through each search result
        for (RemoteWebElement result : searchResults) {
            // Check if the result text matches the provided destination
            if (result.getText().trim().equals(destination)) {
                // If a match is found, click on the result
                result.click();
                break;
            }
        }
    }
}