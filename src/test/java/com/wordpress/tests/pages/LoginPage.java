package com.wordpress.tests.pages;

import com.wordpress.tests.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by asadreev on 7/3/16.
 */
public class LoginPage extends Page{

    @FindBy  (id = "user_login")
     private WebElement userLogin;

    @FindBy (id = "user_pass")
    private WebElement userPassword;

    @FindBy (id = "wp-submit")
    private WebElement submitButton;

    @FindBy (id = "login_error")
    private WebElement loginErrorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        Log.info("Wordpress Login page was created");
    }

    public void logInWordpress(String username, String password){
        Log.info("Log into Wordpress using username(email): " +username+ " and password: "+password);
        userLogin.clear();
        userPassword.clear();
        userLogin.sendKeys(username);
        userPassword.sendKeys(password);
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public String loginWithWrongCredentials(String username, String password){
        Log.info("Log into Wordpress using wrong credentials: " +username+ " and password: "+password);
        userLogin.clear();
        userPassword.clear();
        userLogin.sendKeys(username);
        userPassword.sendKeys(password);
        submitButton.click();
        return loginErrorMessage.getText();
    }
}
