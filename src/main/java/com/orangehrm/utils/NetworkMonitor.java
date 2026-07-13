package com.orangehrm.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v149.network.Network;
import org.openqa.selenium.devtools.v149.network.model.Request;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetworkMonitor {

    private final List<Request> requests = new ArrayList<>();
    private WebDriver driver;

    public void start(WebDriver driver) {

        this.driver = driver;

        DevTools devTools = ((HasDevTools) driver).getDevTools();

        devTools.createSession();

        devTools.send(
                Network.enable(
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()
                )
        );

        devTools.addListener(
                Network.requestWillBeSent(),
                event -> requests.add(event.getRequest())
        );
    }

    public List<Request> getRequests() {
        return requests;
    }

    public boolean wasRequestSent(String urlPart, String method) {

        return requests.stream()
                .anyMatch(request ->
                        request.getUrl().contains(urlPart)
                                && request.getMethod().equalsIgnoreCase(method)
                );
    }

    public boolean waitForRequest(
            String urlPart,
            String method,
            Duration timeout) {

        try {
            return new WebDriverWait(driver, timeout)
                    .until(d -> wasRequestSent(urlPart, method));

        } catch (TimeoutException e) {
            return false;
        }
    }
}