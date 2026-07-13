package com.orangehrm.pages;

import com.orangehrm.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    // Quick Launch Buttons

    public static final By ASSIGN_LEAVE_BUTTON =
            By.cssSelector("button[title='Assign Leave']");

    public static final By LEAVE_LIST_BUTTON =
            By.cssSelector("button[title='Leave List']");

    public static final By TIME_SHEET_BUTTON =
            By.cssSelector("button[title='Timesheets']");

    public static final By APPLY_LEAVE_BUTTON =
            By.cssSelector("button[title='Apply Leave']");

    public static final By MY_LEAVE_BUTTON =
            By.cssSelector("button[title='My Leave']");

    public static final By MY_TIMESHEET_BUTTON =
            By.cssSelector("button[title='My Timesheet']");

    public static final By ATTENDANCE_CARD_BUTTON =
            By.cssSelector(".orangehrm-attendance-card-action");

    public static final By LEAVE_CARD_CONFIG =
            By.cssSelector(".oxd-icon.bi-gear-fill.orangehrm-leave-card-icon");

    // Page Verification Locators

    public static final By ASSIGN_LEAVE_HEADER =
            By.xpath("//h6[text()='Assign Leave']");

    public static final By APPLY_LEAVE_HEADER =
            By.xpath("//h6[text()='Apply Leave']");

    public static final By LEAVE_LIST_HEADER =
            By.xpath("//*[contains(text(),'Leave List')]");

    public static final By TIMESHEET_HEADER =
            By.xpath("//*[contains(text(),'Timesheet')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        openUrl(
                ConfigReader.get("base.url")
                        + "/web/index.php/auth/login"
        );
    }

    public void clickQuickLaunchButton(String type) {

        switch (type.toUpperCase()) {

            case "ASSIGN_LEAVE":
                click(ASSIGN_LEAVE_BUTTON);
                break;

            case "LEAVE_LIST":
                click(LEAVE_LIST_BUTTON);
                break;

            case "TIMESHEET":
                click(TIME_SHEET_BUTTON);
                break;

            case "APPLY_LEAVE":
                click(APPLY_LEAVE_BUTTON);
                break;

            case "MY_LEAVE":
                click(MY_LEAVE_BUTTON);
                break;

            case "MY_TIMESHEET":
                click(MY_TIMESHEET_BUTTON);
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid Quick Launch button type: " + type
                );
        }
    }

    public void waitForDestinationPage(String page) {

        switch (page.toUpperCase()) {

            case "ASSIGN_LEAVE":
                waitUntilPageLoaded(
                        ASSIGN_LEAVE_HEADER,
                        "assignLeave"
                );
                break;

            case "LEAVE_LIST":
                waitUntilPageLoaded(
                        LEAVE_LIST_HEADER,
                        "viewLeaveList"
                );
                break;

            case "TIMESHEET":
                waitUntilPageLoaded(
                        TIMESHEET_HEADER,
                        "viewEmployeeTimesheet"
                );
                break;

            case "APPLY_LEAVE":
                waitUntilPageLoaded(
                        APPLY_LEAVE_HEADER,
                        "applyLeave"
                );
                break;

            case "MY_LEAVE":
                waitForUrlContains("viewMyLeaveList");
                break;

            case "MY_TIMESHEET":
                waitForUrlContains("viewMyTimesheet");
                break;

            default:
                throw new IllegalArgumentException(
                        "Unknown page: " + page
                );
        }
    }

    public void clickAssignLeave() {
        click(ASSIGN_LEAVE_BUTTON);
    }

    public void clickLeaveList() {
        click(LEAVE_LIST_BUTTON);
    }

    public void clickTimesheet() {
        click(TIME_SHEET_BUTTON);
    }

    public void clickApplyLeave() {
        click(APPLY_LEAVE_BUTTON);
    }

    public void clickMyLeave() {
        click(MY_LEAVE_BUTTON);
    }

    public void clickMyTimesheet() {
        click(MY_TIMESHEET_BUTTON);
    }


    public void clickAttendanceCard() {
        click(ATTENDANCE_CARD_BUTTON);
    }

    public void clickLeaveCardConfig() {
        click(LEAVE_CARD_CONFIG);
    }
}