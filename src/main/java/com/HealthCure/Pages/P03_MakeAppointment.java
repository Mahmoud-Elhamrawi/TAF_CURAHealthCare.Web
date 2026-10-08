package com.HealthCure.Pages;

import com.HealthCure.Driver.GUiDriver;
import org.openqa.selenium.By;

public class P03_MakeAppointment {
    private final GUiDriver driver;

    public P03_MakeAppointment(GUiDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By makeApp_Heading= By.xpath("//h2");


    //Method Actions
    public By headingByLocator()
    {
        return makeApp_Heading;
    }




}
