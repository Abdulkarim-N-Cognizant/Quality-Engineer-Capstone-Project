package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.orangehrm.utils.ConfigReader;


public class PasswordResetPage extends BasePage{

    private static final By USERNAME_INPUT = By.name("username");
    private static final By CANCEL = By.cssSelector(".orangehrm-forgot-password-button--cancel");
    private static final By SUBMIT = By.cssSelector("button[type='submit']");


    public void load() {
        openUrl(ConfigReader.get("base.url")
                + "/web/index.php/auth/requestPasswordResetCode");
    }

    public PasswordResetPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String username) {
        typeText(USERNAME_INPUT, username);
    }

    public void clickCancel(){
        click(CANCEL);
    }

    public void clickReset(){
        click(SUBMIT);
    }
}

