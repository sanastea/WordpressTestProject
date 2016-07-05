package com.wordpress.tests.pages;

import com.wordpress.tests.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    //Object[][] credentials = ExcelUtils.getTableArray("/Users/asadreev/IdeaProjects/WordpressTests/src/test/java/com/wordpress/tests/util","Sheet1")

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        Log.info("Wordpress Login page was created");
    }

    public HomePage LoginwithUsername(String username, String password){
        Log.info("Log into Wordpress using username: " +username+ " and password: "+password);
        userLogin.sendKeys(username);
        userPassword.sendKeys(password);
        submitButton.click();
        return PageFactory.initElements(driver,HomePage.class);
    }

    public HomePage LoginwithEmail(String email, String password){
        Log.info("Log into Wordpress using email: " +email+ " and password: "+password);
        userLogin.sendKeys(email);
        userPassword.sendKeys(password);
        submitButton.click();
        return PageFactory.initElements(driver,HomePage.class);
    }
}
