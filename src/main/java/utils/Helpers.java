package utils;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

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
        LEFT,
        RIGHT
    }

    private final PointerInput FINGER = new PointerInput(TOUCH, "finger");


    public void swipe(AndroidDriver driver, Directions direction, int swipeCount) {
        Dimension size = driver.manage().window().getSize();

        int startX, startY, endX, endY;


        switch (direction) {
            case UP:
                startX = size.getWidth() / 2;
                startY = (int) (size.getHeight() * 0.8);
                endX = startX;
                endY = (int) (size.getHeight() * 0.2);
                break;
            case DOWN:
                startX = size.getWidth() / 2;
                startY = (int) (size.getHeight() * 0.2);
                endX = startX;
                endY = (int) (size.getHeight() * 0.8);
                break;
            case LEFT:
                startX = (int) (size.getWidth() * 0.8);
                startY = size.getHeight() / 2;
                endX = (int) (size.getWidth() * 0.2);
                endY = startY;
                break;
            case RIGHT:
                startX = (int) (size.getWidth() * 0.2);
                startY = size.getHeight() / 2;
                endX = (int) (size.getWidth() * 0.8);
                endY = startY;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction selected: " + direction);
        }

        for (int i = 0; i < swipeCount; i++) {
            Sequence swipe = new Sequence(FINGER, 0);

            swipe.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
            swipe.addAction(FINGER.createPointerDown(LEFT.asArg()));
            swipe.addAction(FINGER.createPointerMove(ofMillis(1000), viewport(), endX, endY));
            swipe.addAction(FINGER.createPointerUp(LEFT.asArg()));
            driver.perform(List.of(swipe));
        }
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

    public void wait(int seconds){
        int mSeconds = seconds * 1000; // 1000 milliseconds = 1 seconds
        try {
            Thread.sleep(mSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
