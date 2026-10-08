package com.HealthCure.Utilties.ActionBot;

import com.HealthCure.Utilties.Waitmanager.WaitClass;
import org.openqa.selenium.WebDriver;

public class BrowserAction {

    private WebDriver driver;
    WaitClass waitClass;

    public BrowserAction(WebDriver driver){
        this.driver = driver;
        waitClass = new WaitClass(driver);
    }


    //open url
    public void openURL(String url)
    {
        driver.navigate().to(url);
    }


    //get title
    public String getTitle()
    {
        return driver.getTitle();
    }


    //get current url
    public String getCurrentURL()
    {
        return driver.getCurrentUrl();
    }


}
