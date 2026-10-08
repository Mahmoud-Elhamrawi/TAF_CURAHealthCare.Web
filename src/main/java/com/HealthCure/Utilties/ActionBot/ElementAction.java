package com.HealthCure.Utilties.ActionBot;

import com.HealthCure.Utilties.LogManager.LogClass;
import com.HealthCure.Utilties.Waitmanager.WaitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementAction {
    private WebDriver driver ;
    WaitClass waitClass;

    public ElementAction(WebDriver driver){
        this.driver = driver;
        waitClass = new WaitClass(driver);
    }

    //click
    public void click(By locator){
        waitClass.fluentWait().until(  driver ->
                {
                    try {
                        WebElement ele =  driver.findElement(locator);
                        new Actions(driver).scrollToElement(ele).perform();
                        ele.click();
                        return true;
                    }catch (Exception e)
                    {
                        LogClass.error("failed to click on element: "+locator.toString()+" error: "+e.getMessage());
                        return false;
                    }
                });

    }


    //type
    public void type(By locator, String text){
        waitClass.fluentWait().until(  driver ->
                {
                    try {
                        WebElement ele =  driver.findElement(locator);
                        new Actions(driver).scrollToElement(ele).perform();
                        ele.clear();
                        ele.sendKeys(text);
                        return true;
                    }catch (Exception e)
                    {
                        LogClass.error("failed to type on element: "+locator.toString()+" error: "+e.getMessage());
                        return false;
                    }
                });
    }


    //get Text
    public String getText(By locator){
        return waitClass.fluentWait().until(  driver ->
                {
                    try {
                        WebElement ele =  driver.findElement(locator);
                        new Actions(driver).scrollToElement(ele).perform();
                        String txt = ele.getText();
                        return !txt.isEmpty()?txt:"empty text";
                    }catch (Exception e)
                    {
                        LogClass.error("failed to get text from element: "+locator.toString()+" error: "+e.getMessage());
                        return null;
                    }
                });
    }







}
