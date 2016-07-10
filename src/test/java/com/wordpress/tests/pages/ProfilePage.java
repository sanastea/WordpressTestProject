package com.wordpress.tests.pages;

import com.wordpress.tests.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

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

    @FindBy (css = ".notice__text")
    private WebElement successfulMessage;



    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String saveProfileDetails(){
        Log.info("Saving Profile details");
        saveProfileDetailsButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return successfulMessage.getText();
    }


    public void editFirstName(String newFirstName){
        Log.info("Set first name to new value: " +newFirstName);
        firstNameInput.clear();
        firstNameInput.sendKeys(newFirstName);
    }

    public String getFirstName(){
        Log.info("Get first name:  '" + firstNameInput.getAttribute("value")+"'");
        return firstNameInput.getAttribute("value");
    }

    public void editLastName(String newLastName){
        Log.info("Set last name to new value: " +newLastName);
        lastNameInput.clear();
        lastNameInput.sendKeys(newLastName);
    }

    public String getLastName(){
        Log.info("Get last name:  '" + lastNameInput.getAttribute("value")+"'");
        return lastNameInput.getAttribute("value");
    }

    public void editDisplayName(String newDisplayName){
        Log.info("Set display name to new value: " +newDisplayName);
        displayNameInput.clear();
        displayNameInput.sendKeys(newDisplayName);
    }

    public String getDisplayName(){
        Log.info("Get display name:  '" + displayNameInput.getAttribute("value")+"'");
        return displayNameInput.getAttribute("value");
    }

    public void signOutWordpress(){
        Log.info("Log Out from Wordpress");
        signOutButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}
