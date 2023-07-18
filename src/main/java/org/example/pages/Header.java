package org.example.pages;

import org.example.pages.refefrence.information.ReferenceInformation;
import org.example.utils.SitePropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Header {
    private final WebDriver driver;
    private final ReferenceInformation referenceInformation;
    private PersonalAreaPage personalAreaPage;
    @FindBy(xpath = "//a[@data-testid='signInBtn']")//TODO: переделать на css селекторы
    private WebElement signInButton;
    @FindBy(xpath = "//a[@data-testid='switchForBlindBtn']")
    private WebElement versionForTheVisuallyImpaired;

    public Header(WebDriver driver) {
        this.driver = driver;
        this.referenceInformation = new ReferenceInformation(driver);
        PageFactory.initElements(driver, this);
    }
    public ReferenceInformation getReferenceInformation(){
        return referenceInformation;
    }

    public SignInPage getSignIn(){
        signInButton.click();
        return new SignInPage(driver);
    }

    public void login(){
        String login = SitePropertiesUtil.getProperty("user.login");
        String password = SitePropertiesUtil.getProperty("user.password");
        SignInPage signInPage = getSignIn();
        signInPage.setUsername(login).setPassword(password).auth();
    }// решил сделать два метода авторизации, первый для того, чтобы была возможность протестировать в дальнейшим вход в аккаунт под разными пользователями
    // второй чтобы было удобнее это использовать в других тестах, там где это не требуется

    public PersonalAreaPage getPersonalAreaPage(){
        personalAreaPage = new PersonalAreaPage(driver);
        personalAreaPage.getPage();
        return personalAreaPage;
    }
}
