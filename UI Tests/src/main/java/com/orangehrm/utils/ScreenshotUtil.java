package com.orangehrm.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {

    public static void captureScreenshot(
            WebDriver driver,
            String screenshotName) {

        try {

            String screenshotDirectory =
                    System.getProperty("user.dir")
                            + "/target/screenshots/";

            Files.createDirectories(
                    Path.of(screenshotDirectory));

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            Files.copy(
                    source.toPath(),
                    Path.of(
                            screenshotDirectory
                                    + screenshotName
                                    + "_"
                                    + System.currentTimeMillis()
                                    + ".png"));

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to capture screenshot", e);
        }
    }
}