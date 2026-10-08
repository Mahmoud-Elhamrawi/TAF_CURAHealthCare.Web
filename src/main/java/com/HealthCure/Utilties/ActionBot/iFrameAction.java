package com.HealthCure.Utilties.ActionBot;

import com.HealthCure.Utilties.Waitmanager.WaitClass;
import org.openqa.selenium.WebDriver;

public class iFrameAction {
    private WebDriver driver;
    WaitClass waitClass;

    public iFrameAction(WebDriver driver){
        this.driver = driver;
        waitClass = new WaitClass(driver);
    }


    //switch to frame
    public void switchToFrame(String frameNameOrId)
    {
        waitClass.fluentWait().until(driver -> {
            try {
                driver.switchTo().frame(frameNameOrId);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }






}
