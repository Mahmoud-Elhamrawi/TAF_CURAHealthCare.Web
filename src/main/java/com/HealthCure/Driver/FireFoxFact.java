package com.HealthCure.Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxFact extends AbstractClass{

    private FirefoxOptions getOptions()
    {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return options;
    }



    @Override
    public WebDriver getOwnDriver() {
        return new FirefoxDriver(getOptions());
    }
}
