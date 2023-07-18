package org.example.pages.refefrence.information;

import org.example.pages.SignInPage;
import org.openqa.selenium.WebDriver;
public class ReferenceInformation {
    private final WebDriver driver;
    public ReferenceInformation(WebDriver driver) {
        this.driver = driver;
    }

    public Contacts getContacts(){
        return new Contacts(driver);
    }

    public SearchPolyclinic getSearchPolyclinic(){
        return new SearchPolyclinic(driver);
    }

    public Faq getFaq(){
        return new Faq(driver);
    }

    public Feedback getFeedBack(){
        return new Feedback(driver);
    }

    public SignInPage getSigIn(){
        return new SignInPage(driver);
    }
}
