package com.HealthCure.Utilties.MediaManager;

import com.HealthCure.Utilties.AllureManager.AllureClass;
import com.HealthCure.Utilties.LogManager.LogClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class MediaClass {

    public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + File.separator + "test-output/screenshots/";


    //take screenshot
    public void takeScreenshot(WebDriver driver, String screenName) {
        try {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dist = new File(SCREENSHOT_PATH + screenName + ".png");
            FileUtils.copyFile(src, dist);
            AllureClass.addScreenshotToAllure(screenName, dist.getPath());
            LogClass.info("screenshot taken successfully: " + screenName);
        } catch (Exception e) {
            LogClass.error("failed to take screenshot: " + e.getMessage());

        }
    }


}
