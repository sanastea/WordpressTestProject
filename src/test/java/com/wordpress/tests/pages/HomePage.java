package com.wordpress.tests.pages;

import com.wordpress.tests.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(css = "a.masterbar__item.masterbar__item-new")
  private WebElement createNewPostLink;

  @FindBy(css = "img.gravatar")
  private WebElement myProfileLink;


  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }


  public NewPostPage NavigatetoCreatenewPostPage(){
    Log.info("Navigate to create new post page");
    createNewPostLink.click();
    return  PageFactory.initElements(driver,NewPostPage.class);
  }

  public ProfilePage NavigatetoMyProfilePage(){
    Log.info("Navigate to my profile page");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    myProfileLink.click();
    return PageFactory.initElements(driver,ProfilePage.class);
  }


}
