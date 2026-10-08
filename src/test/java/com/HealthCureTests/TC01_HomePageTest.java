package com.HealthCureTests;

import com.HealthCure.Driver.GUiDriver;
import com.HealthCure.Pages.P01_HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.HealthCure.Utilties.DataManager.ReadPropertyClass.getPropertyKey;

public class TC01_HomePageTest extends BaseTest {

    @Test
    @Description("This test attempts to log into the website")
    @Owner("Mahmoud")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void homePageTC() {
       new P01_HomePage(driver)
               .clickOnMakeAppointmentButton();

        Assert.assertEquals(driver.browser().getCurrentURL(), getPropertyKey("loginPage"), "Login page URL is not matched");

    }

    //Configuration
    @BeforeMethod
    public void beforeMethod() {
        driver = new GUiDriver();
        driver.browser().openURL(getPropertyKey("baseURL"));
    }

    @AfterMethod
    public void afterMethod() {
        driver.clearDriver();
    }


}
