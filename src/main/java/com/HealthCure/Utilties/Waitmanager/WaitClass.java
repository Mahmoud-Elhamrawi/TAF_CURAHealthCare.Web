package com.HealthCure.Utilties.Waitmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;

public class WaitClass {

    private  WebDriver driver ;

    public WaitClass(WebDriver driver){
        this.driver = driver;
    }

    public FluentWait<WebDriver> fluentWait()
    {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5000))
                .ignoreAll(exceptions());
    }


    private ArrayList<Class <? extends Exception>> exceptions()
    {
        ArrayList<Class <? extends Exception>> exceptions = new ArrayList<>();
        exceptions.add(org.openqa.selenium.NoSuchElementException.class);
        exceptions.add(org.openqa.selenium.ElementNotInteractableException.class);
        exceptions.add(org.openqa.selenium.StaleElementReferenceException.class);
        return exceptions;
    }


}
