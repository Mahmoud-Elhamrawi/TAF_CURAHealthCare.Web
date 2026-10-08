package com.HealthCure.Utilties.ActionBot;

import com.HealthCure.Utilties.Waitmanager.WaitClass;
import org.openqa.selenium.WebDriver;

public class AlertAction {
    private WebDriver driver;
    WaitClass waitClass;

    public AlertAction(WebDriver driver){
        this.driver = driver;
        waitClass = new WaitClass(driver);
    }

    //switch to alert
    public void switchToAlert()
    {
        waitClass.fluentWait().until(driver -> {
            try {
                driver.switchTo().alert();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }


    // accept alert
    public void acceptAlert()
    {
        waitClass.fluentWait().until(driver -> {
            try {
                driver.switchTo().alert().accept();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }


    //dismiss alert
    public void dismissAlert()
    {
        waitClass.fluentWait().until(driver -> {
            try {
                driver.switchTo().alert().dismiss();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    //get text from alert
    public String getAlertText()
    {
        return waitClass.fluentWait().until(driver -> {
            try {
                return driver.switchTo().alert().getText();
            } catch (Exception e) {
                return null;
            }
        });
    }


}
