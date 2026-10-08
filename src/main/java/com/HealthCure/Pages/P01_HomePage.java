package com.HealthCure.Pages;

import com.HealthCure.Driver.GUiDriver;
import org.openqa.selenium.By;

public class P01_HomePage {
    public GUiDriver driver;

    public P01_HomePage(GUiDriver driver) {
        this.driver = driver;
    }

    //locators
    private final By make_Appointment_button = By.id("btn-make-appointment");


    //method actions
    public P02_LoginPage clickOnMakeAppointmentButton() {
        driver.element().click(make_Appointment_button);
        return new P02_LoginPage(driver);

    }




}
