package com.HealthCureTests;

import com.HealthCure.Driver.GUiDriver;
import com.HealthCure.Pages.P02_LoginPage;
import com.HealthCure.Pages.P03_MakeAppointment;
import com.HealthCure.Utilties.DataManager.ReadJsonClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.HealthCure.Utilties.DataManager.ReadJsonClass.getJsonKey;
import static com.HealthCure.Utilties.DataManager.ReadPropertyClass.getPropertyKey;

public class TC02_LoginTest extends BaseTest {

    @Test
    public void loginTC()
    {
        new P02_LoginPage(driver)
                .enterUserName(getJsonKey("validLoginData.userName"))
                .enterPassword(getJsonKey("validLoginData.password"))
                .clickOnLoginButton();

        Assert.assertEquals(driver.browser().getCurrentURL(), getPropertyKey("makeAppointment"), "Make Appointment page URL is not matched");
        Assert.assertEquals(driver.element().getText(new P03_MakeAppointment(driver).headingByLocator()),"Make Appointment");
    }


    //Configuration
    @BeforeClass
    public void beforeClass()
    {
         new ReadJsonClass("login-data");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        driver = new GUiDriver();
        driver.browser().openURL(getPropertyKey("loginPage"));
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.clearDriver();
    }

}
