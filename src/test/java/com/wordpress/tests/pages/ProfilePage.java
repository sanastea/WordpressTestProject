package com.wordpress.tests.pages;

import com.wordpress.tests.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by asadreev on 7/3/16.
 */
public class ProfilePage extends Page{


    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "display_name")
    private WebElement displayName;

    @FindBy(css = "button.form-button.button.is-primary")
    private WebElement saveProfileDetailsButton;

    @FindBy(css = "button.me-sidebar__signout-button.form-button button")
    private WebElement signOutButton;


    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void editFirstName(String newFirstName){
        firstName.sendKeys(newFirstName);
        saveProfileDetailsButton.click();
    }

    public void editLastName(String newLastName){
        lastName.sendKeys(newLastName);
        saveProfileDetailsButton.click();
    }

    public void editDisplayName(String newDisplayName){
        displayName.sendKeys(newDisplayName);
        saveProfileDetailsButton.click();
    }

    public void signOutWordpress(){
        Log.info("Log Out from Wordpress");
        signOutButton.click();
    }


}
