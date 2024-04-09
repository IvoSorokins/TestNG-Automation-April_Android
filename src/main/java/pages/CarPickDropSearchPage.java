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

public class CarPickDropSearchPage {
    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/search_query_edittext")
    private RemoteWebElement searchBarTextBox;

    @AndroidFindBy(id = "com.booking:id/search_hint_text")
    private RemoteWebElement searchHint;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]")
    private RemoteWebElement secondSearchResult;


    public CarPickDropSearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Destination Search page is loaded")
    public boolean carPickDropSearchPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchHint)).isDisplayed();
    }

    @Step("Entered Pick Up destination: '{destination}' ")
    public void enterPickUpLocation(String destination) {searchBarTextBox.sendKeys(destination);}

    @Step("Entered Drop Off destination: '{destination}' ")
    public void enterDropOffLocation(String destination) {searchBarTextBox.sendKeys(destination);}

    @Step("Clicked Second Search Result")
    public void clickSecondSearchResult(){secondSearchResult.click();}
}
