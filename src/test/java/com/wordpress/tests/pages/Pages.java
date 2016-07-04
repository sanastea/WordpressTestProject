package com.wordpress.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by asadreev on 7/3/16.
 */
public class Pages {

    public static LoginPage loginpage(WebDriver driver){
        return PageFactory.initElements(driver,LoginPage.class);
    }

    public static NewPostPage newpostpage(WebDriver driver){
        return PageFactory.initElements(driver,NewPostPage.class);
    }


    public static ProfilePage profilePage(WebDriver driver){
        return PageFactory.initElements(driver,ProfilePage.class);

    }

    public static HomePage homepage (WebDriver driver){
        return PageFactory.initElements(driver,HomePage.class);
    }

}
