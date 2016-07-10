package com.wordpress.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by asadreev on 7/6/16.
 */
public class LoginTests extends TestNgTestBase {

    @BeforeMethod ()
    public void openNewWordpressPage() {
        driver.get("https://wordpress.com/wp-login.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(description = "Login into Wordpress with username")
    public void logInwithUserName() {
        pages.loginpage(driver).logInWordpress("testautomation728", "!234tesT;");
        Assert.assertEquals(pages.homepage(driver).getTitle(),"Following ‹ Reader — WordPress.com");
        pages.homepage(driver).NavigatetoMyProfilePage();
        pages.profilePage(driver).signOutWordpress();

    }

    @Test(description = "Login into Wordpress with email")
    public void logInwithEmail() {
        pages.loginpage(driver).logInWordpress("sanastea@mail.ru", "!234tesT;");
        pages.homepage(driver).getTitle();
        Assert.assertEquals(pages.homepage(driver).getTitle(),"Following ‹ Reader — WordPress.com");
        pages.homepage(driver).NavigatetoMyProfilePage();
        pages.profilePage(driver).signOutWordpress();
    }

    @Test(description = "Login into Wordpress with wrong credentials")
    public void logInWithWrongCredentials() {
        String loginErr = "ERROR: Invalid email or username. Lost your password?";
        Assert.assertEquals(pages.loginpage(driver).loginWithWrongCredentials("test_wrong", "test_wrong"),loginErr);
        Assert.assertEquals(pages.homepage(driver).getTitle(),"WordPress.com ‹ Log In");
    }

}