package com.wordpress.tests.pages;

import com.wordpress.tests.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


  public void NavigatetoCreatenewPostPage(){
    Log.info("Navigate to create new post page");
    createNewPostLink.click();
  }

  public void NavigatetoMyProfilePage(){
    Log.info("Navigate to my profile page");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    myProfileLink.click();
  }


}
