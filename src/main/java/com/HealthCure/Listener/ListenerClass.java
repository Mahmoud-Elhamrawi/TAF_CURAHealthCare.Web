package com.HealthCure.Listener;

import com.HealthCure.Driver.getWebDriverProvider;
import com.HealthCure.Utilties.LogManager.LogClass;
import com.HealthCure.Utilties.MediaManager.MediaClass;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;

import static com.HealthCure.Utilties.AllureManager.AllureClass.*;
import static com.HealthCure.Utilties.DataManager.ReadPropertyClass.loadProperty;
import static com.HealthCure.Utilties.FileManager.FileClass.deleteFiles;
import static com.HealthCure.Utilties.LogManager.LogClass.LOG_PATH;
import static com.HealthCure.Utilties.MediaManager.MediaClass.SCREENSHOT_PATH;

public class ListenerClass implements ITestListener, IInvokedMethodListener, IExecutionListener {



@Override
    public void onExecutionStart() {
    LogClass.info("Execution Started...");
    loadProperty();
    deleteFiles(new File(LOG_PATH));
    deleteFiles(new File(AlLURE_PATH));
    deleteFiles(new File(SCREENSHOT_PATH));

    }


    @Override
    public void onTestStart(ITestResult result) {
    LogClass.info("Test Case ",result.getName() , " Started");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
    LogClass.info("Test Case ",result.getName() , " Passed");
    }


    @Override
    public void onTestFailure(ITestResult result) {
    LogClass.error("Test Case ",result.getName() , " Failed");
    }


    @Override
    public void onTestSkipped(ITestResult result) {
    LogClass.warn("Test Case ",result.getName() , " Skipped");
    }

    @Override
    public void onStart(ITestContext context) {
    LogClass.info("Test Suite ",context.getName() , " Started");
    }


    @Override
    public void onFinish(ITestContext context) {
    LogClass.info("Test Suite ",context.getName() , " Finished");
    }


    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
      if(method.isTestMethod())
      {
          WebDriver driver =null;
          if(testResult.getInstance() instanceof getWebDriverProvider provider)
              driver = provider.getWebDriverProvider();
       switch (testResult.getStatus())
       {
              case ITestResult.SUCCESS->new MediaClass().takeScreenshot(driver, "Success_" + testResult.getName());
              case ITestResult.FAILURE->new MediaClass().takeScreenshot(driver, "Failure_" + testResult.getName());
              case ITestResult.SKIP->new MediaClass().takeScreenshot(driver, "Skipped_" + testResult.getName());
       }
          addLogsToAllure();
      }
    }


    @Override
    public void onExecutionFinish() {
    LogClass.info("Execution Finished...");
        generateAllure();
        openAllureReport();
    }






}
