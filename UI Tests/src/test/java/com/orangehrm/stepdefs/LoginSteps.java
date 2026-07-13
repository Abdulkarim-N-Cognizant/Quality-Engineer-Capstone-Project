package com.orangehrm.stepdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSteps {

    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void openLoginPage() {
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.load();
    }

    @When("the user enters username {string} on the login page")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        takeScreenshot("LoginUsernameEntered");
    }

    @When("the user enters password {string} on the login page")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("the dashboard should be displayed")
    public void verifyDashboardPage() {

        loginPage.waitForDashboardPage();

        String currentUrl =
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .toLowerCase();

        assertTrue(
                currentUrl.contains("dashboard"),
                "Dashboard page was not displayed"
        );

        takeScreenshot("DashboardDisplayed");
    }

    @Then("the Invalid Credentials Alert should be displayed")
    public void verifyInvalidCredentialsAlert() {

        loginPage.waitForLoginError();

        assertTrue(
                loginPage.getErrorText()
                        .equals("Invalid credentials"),
                "The Invalid credentials pop up did not occur"
        );

        takeScreenshot("InvalidCredentialsDisplayed");
    }

    @When("the user clicks the Forgot your Password? hyperlink")
    public void clickForgotPassword() {
        loginPage.clickForgotPassword();
    }

    @Then("the user is directed to the password reset page")
    public void verifyPasswordResetPage() {

        loginPage.waitForResetPasswordPage();

        String currentUrl =
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .toLowerCase();

        assertTrue(
                currentUrl.contains("requestpasswordresetcode"),
                "Password reset page was not displayed"
        );

        takeScreenshot("PasswordResetPageDisplayed");
    }
}