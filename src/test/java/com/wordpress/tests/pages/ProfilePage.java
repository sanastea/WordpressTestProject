package com.wordpress.tests.pages;

import com.wordpress.tests.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by asadreev on 7/3/16.
 */
public class ProfilePage extends Page{


    @FindBy(id = "first_name")
    @CacheLookup
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    @CacheLookup
    private WebElement lastNameInput;

    @FindBy(id = "display_name")
    @CacheLookup
    private WebElement displayNameInput;

    @FindBy(css = "button.form-button.button.is-primary")
    @CacheLookup
    private WebElement saveProfileDetailsButton;

    @FindBy(css = "button.me-sidebar__signout-button.form-button.button")
    @CacheLookup
    private WebElement signOutButton;


    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }


    public void editFirstName(String newFirstName){
        Log.info("Set first name to new value: " +newFirstName);
        firstNameInput.clear();
        firstNameInput.sendKeys(newFirstName);
        saveProfileDetailsButton.click();
        saveProfileDetailsButton.isEnabled();
    }

    public String getFirstName(){
        Log.info("Get first name:  '" + firstNameInput.getAttribute("value")+"'");
        return firstNameInput.getAttribute("value");
    }

    public void editLastName(String newLastName){
        Log.info("Set last name to new value: " +newLastName);
        lastNameInput.clear();
        lastNameInput.sendKeys(newLastName);
        saveProfileDetailsButton.click();
        saveProfileDetailsButton.isEnabled();
    }

    public String getLastName(){
        Log.info("Get last name:  '" + lastNameInput.getAttribute("value")+"'");
        return lastNameInput.getAttribute("value");
    }

    public void editDisplayName(String newDisplayName){
        Log.info("Set display name to new value: " +newDisplayName);
        displayNameInput.clear();
        displayNameInput.sendKeys(newDisplayName);
        saveProfileDetailsButton.click();
        saveProfileDetailsButton.isEnabled();
    }

    public String getDisplayName(){
        Log.info("Get display name:  '" + displayNameInput.getAttribute("value")+"'");
        return displayNameInput.getAttribute("value");
    }

    public void signOutWordpress(){
        Log.info("Log Out from Wordpress");
        signOutButton.click();
    }


}
