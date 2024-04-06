package utils;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;


import java.util.List;
import java.util.stream.IntStream;

import static java.time.Duration.*;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

/**
 * Utility class containing helper methods for interacting with elements
 */
public class Helpers {

    /**
     * Enumeration representing directions for swiping actions.
     */
    public enum Directions {
        UP,
        DOWN,
    }

    private final PointerInput FINGER = new PointerInput(TOUCH, "finger");

    /**
     * Performs a vertical swipe action on the Android device
     *
     * @param driver    Driver instance
     * @param direction The direction of the swipe (UP or DOWN)
     */
    public void swipeVertically(AndroidDriver driver, Directions direction) {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

        int endY;

        switch (direction) {
            case UP -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
            case DOWN -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
            default -> throw new IllegalArgumentException("Invalid direction selected: " + direction);
        }

        Sequence swipe = new Sequence(FINGER, 0);

        swipe.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipe.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipe.addAction(FINGER.createPointerMove(ofMillis(1000), viewport(), startX, endY));
        swipe.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    /**
     * Scrolls to an element on the device by performing vertical swipes
     * If the element is not visible, it will perform vertical swipes for the specified number of times
     *
     * @param driver     Driver instance
     * @param el         The WebElement to scroll to
     * @param direction  The direction of the scroll (UP or DOWN)
     * @param swipeCount The number of swipes to perform
     */
    public void scrollTo(AndroidDriver driver, WebElement el, Directions direction, int swipeCount) {
        IntStream.range(0, swipeCount).forEach(obj -> {
            if (!el.isDisplayed())
                swipeVertically(driver, direction);
        });
    }

    /**
     * Performs a long press action on an element on the iOS device
     *
     * @param driver Driver instance
     * @param el     The WebElement to long press
     */
    public void longPress(AndroidDriver driver, WebElement el) {
        Point location = getElementCenter(el);
        Sequence longPressAction = new Sequence(FINGER, 0);
        longPressAction.addAction(FINGER.createPointerMove(ZERO, viewport(), location.x, location.y));
        longPressAction.addAction(FINGER.createPointerDown(LEFT.asArg()));
        longPressAction.addAction(FINGER.createPointerMove(ofSeconds(1), viewport(), location.x, location.y));
        longPressAction.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(longPressAction));
    }

    /**
     * Calculates the center point of a WebElement
     *
     * @param el The WebElement
     * @return The center point of the WebElement
     */
    public Point getElementCenter(WebElement el) {
        Point location = el.getLocation();
        Dimension size = el.getSize();
        return new Point(location.x + size.getWidth() / 2, location.y + size.getHeight() / 2);
    }

    /**
     * Clicks on a given element multiple times.
     *
     * @param element The element to be clicked multiple times.
     * @param clicks   The number of times to click the element.
     */
    public static void clickElementMultipleTimes(RemoteWebElement element, int clicks){
        for(int i = 0; i< clicks; i++){
            element.click();
        }
    }

    public void scrollFromElementToElement(AndroidDriver driver, WebElement fromElement, WebElement toElement) {
        Point fromLocation = getElementCenter(fromElement);
        Point toLocation = getElementCenter(toElement);

        Sequence swipe = new Sequence(FINGER, 0);
        swipe.addAction(FINGER.createPointerMove(ZERO, viewport(), fromLocation.x, fromLocation.y));
        swipe.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipe.addAction(FINGER.createPointerMove(ofMillis(1000), viewport(), toLocation.x, toLocation.y));
        swipe.addAction(FINGER.createPointerUp(LEFT.asArg()));

        driver.perform(List.of(swipe));
    }
}
