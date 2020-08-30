package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumHelper {

    private FluentWait<WebDriver> webDriverWait;

    public SeleniumHelper(long maxWaitTimeInSeconds, WebDriver webDriver) {
        webDriverWait = new FluentWait<>(webDriver);
        webDriverWait.withTimeout(maxWaitTimeInSeconds, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(250, TimeUnit.MILLISECONDS);
    }
    public FluentWait<WebDriver> getWebDriverWait() {
        return webDriverWait;
    }

    public WebElement untilElementClickable(By locator) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement untilElementVisible(By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
