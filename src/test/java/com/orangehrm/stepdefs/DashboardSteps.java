package com.orangehrm.stepdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orangehrm.pages.DashboardPage;
import com.orangehrm.utils.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps extends BaseSteps {

    private DashboardPage dashboardPage;

    @When("the user clicks {string} on the dashboard")
    public void clickDashboardOption(String dashboardOption) {

        dashboardPage =
                new DashboardPage(DriverFactory.getDriver());

        dashboardPage.clickQuickLaunchButton(
                dashboardOption
        );

        takeScreenshot(
                dashboardOption + "_Clicked"
        );
    }

    @Then("the user should be redirected to {string}")
    public void verifyNavigation(String dashboardOption) {

        dashboardPage =
                new DashboardPage(DriverFactory.getDriver());

        dashboardPage.waitForDestinationPage(
                dashboardOption
        );

        assertTrue(
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .length() > 0
        );

        takeScreenshot(
                dashboardOption + "_Loaded"
        );
    }
}