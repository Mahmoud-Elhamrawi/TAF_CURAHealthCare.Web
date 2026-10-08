package com.HealthCure.Pages;

import com.HealthCure.Driver.GUiDriver;
import org.openqa.selenium.By;

public class P02_LoginPage {

    public P02_LoginPage(GUiDriver driver) {
        this.driver = driver;
    }

    GUiDriver driver;

    //Locators
    private final By username_input = By.id("txt-username");
    private final By password_input = By.id("txt-password");
    private final By login_button = By.id("btn-login");


    //Method Actions
    public P02_LoginPage enterUserName(String username) {
        driver.element().type(username_input, username);
        return this;
    }

    public P02_LoginPage enterPassword(String password) {
        driver.element().type(password_input, password);
        return this;
    }

    public P03_MakeAppointment clickOnLoginButton() {
        driver.element().click(login_button);
        return new P03_MakeAppointment(driver);
    }



}
