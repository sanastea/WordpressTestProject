package com.wordpress.tests.pages;

import com.wordpress.tests.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by asadreev on 7/3/16.
 */
public class NewPostPage extends Page{
    @FindBy (css = "input.editor-title__input.form-text-input")
    private WebElement postTitle;

    @FindBy (css = "textarea.tinymce.is-visible")
    private WebElement postBody;

    @FindBy (xpath = "//a[span[@class='segmented-control__text'][text()='HTML']]")
    private WebElement htmlTab;

    @FindBy(css = "button.editor-ground-control__publish-button.button.is-primary")
    private WebElement publishButton;

    @FindBy(xpath = "//span[@class='notice__text']/a")
    private WebElement notice;

    public NewPostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String publishPost(String title, String postText){
        Log.info("Create a post with '" +title+ "' title and '"+postText+ "' body" );
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        postTitle.sendKeys(title);
        htmlTab.click();
        postBody.sendKeys(postText);
        publishButton.click();
        return notice.getText();

    }


}
