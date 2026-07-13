package com.orangehrm.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    private static final int DEFAULT_TIMEOUT = 15;

    public BasePage(WebDriver driver) {
        this(driver, DEFAULT_TIMEOUT);
    }

    public BasePage(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(timeoutSeconds)
        );

        wait.ignoring(StaleElementReferenceException.class);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    /*
     * WAIT METHODS
     */

    protected WebElement waitForVisible(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean waitForInvisibility(By locator) {
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected boolean waitForUrlContains(String text) {
        return wait.until(
                ExpectedConditions.urlContains(text));
    }

    protected boolean waitForText(By locator, String text) {
        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        locator,
                        text));
    }

    /*
     * ELEMENT METHODS
     */

    public WebElement findVisibleElement(By locator) {
        return waitForVisible(locator);
    }

    public List<WebElement> findElements(By locator) {
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void click(By locator) {
        waitForClickable(locator).click();
    }

    public void typeText(By locator, String text) {
        WebElement element = waitForVisible(locator);

        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return waitForVisible(locator)
                .getText()
                .trim();
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void waitUntilVisible(By locator) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    protected void waitUntilPageLoaded(By locator, String urlPart) {

        wait.until(
                ExpectedConditions.urlContains(urlPart)
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }
}