package com.orangehrm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static WebDriver driver;
    private static NetworkMonitor networkMonitor;

    public static WebDriver getDriver() {
        return driver;
    }

    public static NetworkMonitor getNetworkMonitor() {
        return networkMonitor;
    }

    public static void initializeDriver() {

        System.out.println("Initializing Driver...");

        if (driver == null) {

            String browser = System.getProperty(
                    "browser",
                    ConfigReader.get("browser")
            );

            switch (browser.toLowerCase()) {

                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "chrome":
                default:
                    driver = new ChromeDriver();
                    break;
            }

            driver.manage().window().maximize();

            networkMonitor = new NetworkMonitor();
            networkMonitor.start(driver);

            System.out.println("Created monitor: " + networkMonitor);
        }
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
            networkMonitor = null;
        }
    }
}