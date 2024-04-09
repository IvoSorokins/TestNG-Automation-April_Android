package components;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;


public class TopNavigationBar {

    protected AndroidDriver driver;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Stays']")
    private RemoteWebElement staysOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Car rental']")
    private RemoteWebElement carRentalOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Taxi']")
    private RemoteWebElement taxiOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Attractions']")
    private RemoteWebElement attractionsOption;

    public TopNavigationBar(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public RemoteWebElement getCarRentalOption(){return carRentalOption;}
    public RemoteWebElement getStaysOption(){return staysOption;}
    public RemoteWebElement getTaxiOption(){return taxiOption;}
    public RemoteWebElement getAttractionsOption(){return attractionsOption;}

}
