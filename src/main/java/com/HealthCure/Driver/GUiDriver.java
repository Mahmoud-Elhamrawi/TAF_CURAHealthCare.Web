package com.HealthCure.Driver;

import com.HealthCure.Utilties.ActionBot.AlertAction;
import com.HealthCure.Utilties.ActionBot.BrowserAction;
import com.HealthCure.Utilties.ActionBot.ElementAction;
import com.HealthCure.Utilties.ActionBot.iFrameAction;
import com.HealthCure.Utilties.LogManager.LogClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import static com.HealthCure.Utilties.DataManager.ReadPropertyClass.getPropertyKey;

public class GUiDriver {


    public String Browser = getPropertyKey("browserName");
    ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public GUiDriver() {
        LogClass.info("Driver that initialized : ", Browser);
        BrowserEnum browserEnum = BrowserEnum.valueOf(Browser.toUpperCase()); //EDGE
        AbstractClass abstractClass = browserEnum.getDriver();
        WebDriver driver = abstractClass.getOwnDriver();
        threadLocal.set(ThreadGuard.protect(driver));


    }


    public WebDriver getDriver() {
        return threadLocal.get();
    }

    public void clearDriver() {
        if (threadLocal.get() != null) {
            threadLocal.get().quit();
            threadLocal.remove();
        }
    }


    public ElementAction element()
    {
        return new ElementAction(getDriver());
    }

    public BrowserAction browser()
    {
        return new BrowserAction(getDriver());
    }

    public AlertAction alert()
    {
        return new AlertAction(getDriver());
    }

    public iFrameAction iframe()
    {
        return new iFrameAction(getDriver());
    }



}
