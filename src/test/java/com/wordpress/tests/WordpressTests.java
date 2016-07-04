package com.wordpress.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by asadreev on 7/3/16.
 */
public class WordpressTests extends TestNgTestBase {

    @BeforeMethod
    public void logIntoWordpress(){
        driver.get(" https://wordpress.com/wp-login.php");
        pages.loginpage(driver).LoginwithUsername("testautomation728","!234tesT;");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test(description = "Login into Wordpress with username", enabled= false)
    public void logInwithUserName(){
        driver.get(" https://wordpress.com/wp-login.php");
        pages.loginpage(driver).LoginwithUsername("testautomation728","!234tesT;");
    }


    @Test(description = "Login into Wordpress with email", enabled = false)
    public void logInwithEmail(){
        driver.get(" https://wordpress.com/wp-login.php");
        pages.loginpage(driver).LoginwithEmail("sanastea@mail.ru","!234tesT;");
    }

    @Test(description = "Add new post")
    public void addNewPost(){
        pages.homepage(driver).NavigatetoCreatenewPostPage();
        pages.newpostpage(driver).publishPost("Test title","Body of the test post");
        //Assert.assertTrue(""pages.newpostpage(driver).publishPost("Test title","Body of the test post");

    }

    @Test(description = "Edit profile data")
    public void editProfile(){
        pages.homepage(driver).NavigatetoMyProfilePage();
        pages.profilePage(driver).editDisplayName("newDisplayName");
        pages.profilePage(driver).editFirstName("newFirstName");
        pages.profilePage(driver).editLastName("newLastName");
    }

    @AfterMethod
    public void logOutWordpress(){
        pages.homepage(driver).NavigatetoMyProfilePage();
        pages.profilePage(driver).signOutWordpress();
    }

  @AfterSuite
    public void CloseDriver(){
      driver.close();
  }


}
