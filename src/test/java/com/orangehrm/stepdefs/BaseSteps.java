package com.orangehrm.stepdefs;

import com.orangehrm.utils.DriverFactory;
import com.orangehrm.utils.ScreenshotUtil;

public class BaseSteps {

    protected void takeScreenshot(String screenshotName) {
        ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                screenshotName
        );
    }
}