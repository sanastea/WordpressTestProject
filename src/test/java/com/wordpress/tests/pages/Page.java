package com.wordpress.tests.pages;
import com.wordpress.tests.util.Log;
import org.openqa.selenium.WebDriver;


/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  public WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    Log.info("Get page title: " +driver.getTitle());
    return driver.getTitle();

  }

}
