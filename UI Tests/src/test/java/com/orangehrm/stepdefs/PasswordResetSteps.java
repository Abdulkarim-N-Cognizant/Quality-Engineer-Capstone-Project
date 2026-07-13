package com.orangehrm.stepdefs;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orangehrm.pages.PasswordResetPage;
import com.orangehrm.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordResetSteps extends BaseSteps {

    private PasswordResetPage passwordResetPage;

    @Given("the user is on the password reset page")
    public void openPasswordResetPage() {

        passwordResetPage =
                new PasswordResetPage(DriverFactory.getDriver());

        passwordResetPage.load();

        takeScreenshot("PasswordResetPageLoaded");
    }

    @When("the user enters username {string} on the password reset page")
    public void enterUsername(String username) {

        passwordResetPage.enterUsername(username);

        takeScreenshot("PasswordResetUsernameEntered");
    }

    @When("the user clicks the Reset Password Button")
    public void clickReset() {

        passwordResetPage.clickReset();

        takeScreenshot("PasswordResetSubmitted");
    }

    @When("the user clicks the cancel button on the password reset page")
    public void clickCancel() {

        passwordResetPage.clickCancel();

        takeScreenshot("PasswordResetCancelled");
    }

    @Then("the user is sent to the Login Page")
    public void verifyLoginPage() {

        String currentUrl =
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .toLowerCase();

        assertTrue(
                currentUrl.contains("login"),
                "Login page was not displayed"
        );

        takeScreenshot("LoginPageDisplayed");
    }

    @Then("a Password Reset Request is sent")
    public void verifyRequestSent() {

        assertTrue(
                DriverFactory.getNetworkMonitor()
                        .waitForRequest(
                                "requestResetPassword",
                                "POST",
                                Duration.ofSeconds(10)
                        ),
                    "Password reset request was not sent"
        );

        takeScreenshot("PasswordResetRequestVerification");
    }
}