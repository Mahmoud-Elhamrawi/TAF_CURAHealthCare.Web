package com.HealthCure.Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFact extends AbstractClass {

    @Override
    public WebDriver getOwnDriver() {
        return new ChromeDriver(getOptions());
    }


    private ChromeOptions getOptions()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
//        options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return options;
    }


}
