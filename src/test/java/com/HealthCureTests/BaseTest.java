package com.HealthCureTests;

import com.HealthCure.Driver.GUiDriver;
import com.HealthCure.Driver.getWebDriverProvider;
import org.openqa.selenium.WebDriver;

public class BaseTest implements getWebDriverProvider {

    GUiDriver driver;



    @Override
    public WebDriver getWebDriverProvider() {
        return driver.getDriver();
    }
}
