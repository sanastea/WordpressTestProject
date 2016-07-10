package com.wordpress.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by asadreev on 7/10/16.
 */
public class ProfileTests extends TestNgTestBase {

    private String firstName = "Test1";
    private String lastName = "Test2";
    private String displayName = "Test3";
    private String successfulMessage = "Settings saved successfully!";

    @BeforeMethod
    public void logIntoWordpress() {
        driver.get(" https://wordpress.com/wp-login.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pages.loginpage(driver).logInWordpress("testautomation728", "!234tesT;");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(description = "Edit profile first name")
    public void editProfileFirstName() {
        pages.homepage(driver).NavigatetoMyProfilePage();
        pages.profilePage(driver).editFirstName(firstName);
        Assert.assertEquals(pages.profilePage(driver).saveProfileDetails(),successfulMessage);
        Assert.assertEquals(pages.profilePage(driver).getFirstName(), firstName);
    }

    @Test(description = "Edit profile last name")
    public void editProfileLastName() {
        pages.homepage(driver).NavigatetoMyProfilePage();
        pages.profilePage(driver).editLastName(lastName);
        Assert.assertEquals(pages.profilePage(driver).saveProfileDetails(),successfulMessage);
        Assert.assertEquals(pages.profilePage(driver).getLastName(), lastName);
    }

    @Test(description = "Edit profile display name")
    public void editProfileDisplayName() {
        pages.homepage(driver).NavigatetoMyProfilePage();
        pages.profilePage(driver).editDisplayName(displayName);
        Assert.assertEquals(pages.profilePage(driver).saveProfileDetails(),successfulMessage);
        Assert.assertEquals(pages.profilePage(driver).getDisplayName(), displayName);
    }

    @AfterMethod
    public void logOutWordpress() {
        pages.homepage(driver).NavigatetoMyProfilePage();
        pages.profilePage(driver).signOutWordpress();
    }
}
