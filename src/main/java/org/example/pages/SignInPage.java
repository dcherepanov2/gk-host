package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SignInPage {
    public final WebDriver webDriver;

    private final Logger logger = Logger.getLogger(SignInPage.class.getName());

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='kc-login']")
    private WebElement submitButton;

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public SignInPage setUsername(String username){
        logger.log(Level.INFO, "Авторизация с именем пользователя: "+ username);
        userNameField.sendKeys(username);
        return this;
    }

    public SignInPage setPassword(String password){
        logger.log(Level.INFO, "Авторизация с паролем: " + password);
        passwordField.sendKeys(password);
        return this;
    }

    public void auth(){
        submitButton.click();
    }
}
