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

public class SelectDatePage {

    protected AndroidDriver driver;

    @AndroidFindBy(id="id/facet_with_bottom_sheet_header_content")
    private RemoteWebElement calendarWidget;

    public SelectDatePage(io.appium.java_client.android.AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Select Date page is loaded")
    public boolean mainPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(accommodationBox)).isDisplayed();
    }

}
