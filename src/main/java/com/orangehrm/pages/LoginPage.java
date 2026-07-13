package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.utils.ConfigReader;

public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT =
            By.name("username");

    private static final By PASSWORD_INPUT =
            By.name("password");

    private static final By LOGIN_BUTTON =
            By.cssSelector("button[type='submit']");

    private static final By FORGOT_LOGIN =
            By.cssSelector(".orangehrm-login-forgot-header");

    private static final By ERROR_POPUP =
            By.cssSelector("div.oxd-alert.oxd-alert--error");

    // Dashboard page identifier after successful login
    private static final By DASHBOARD_HEADER =
            By.xpath("//h6[text()='Dashboard']");

    // Forgot password page identifier
    private static final By RESET_PASSWORD_HEADER =
            By.xpath("//h6[text()='Reset Password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void load() {

        openUrl(
                ConfigReader.get("base.url")
                        + "/web/index.php/auth/login"
        );
    }

    public void enterUsername(String username) {
        typeText(USERNAME_INPUT, username);
    }

    public void enterPassword(String password) {
        typeText(PASSWORD_INPUT, password);
    }

    public void clickLogin() {
        click(LOGIN_BUTTON);
    }

    public void clickForgotPassword() {
        click(FORGOT_LOGIN);
    }

    public String getErrorText() {
        return getText(ERROR_POPUP);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    /**
     * Wait for successful login.
     */
    public void waitForDashboardPage() {

        waitUntilPageLoaded(
                DASHBOARD_HEADER,
                "dashboard"
        );
    }

    /**
     * Wait for forgot password page.
     */
    public void waitForResetPasswordPage() {

        waitUntilPageLoaded(
                RESET_PASSWORD_HEADER,
                "requestPasswordResetCode"
        );
    }

    /**
     * Wait for login error.
     */
    public void waitForLoginError() {

        waitUntilVisible(ERROR_POPUP);
    }
}