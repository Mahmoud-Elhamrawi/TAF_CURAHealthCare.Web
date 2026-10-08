package com.HealthCure.Utilties.AllureManager;

import com.HealthCure.Utilties.FileManager.FileClass;
import com.HealthCure.Utilties.LogManager.LogClass;
import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.util.Objects;

import static com.HealthCure.Utilties.Commandmanager.CommandClass.executeCommand;
import static com.HealthCure.Utilties.DataManager.ReadPropertyClass.getPropertyKey;

public class AllureClass {
    public static final String AlLURE_PATH = System.getProperty("user.dir") + File.separator + "test-output/allure-results/";


    //add log to allure
    public static void addLogsToAllure() {
        try {
            File log = FileClass.getLastFile(LogClass.LOG_PATH);
            Allure.attachment("log File", Files.readString(log.toPath()));
            LogClass.info("success to add logs to allure");
        } catch (Exception e) {
            LogClass.error("failed to add logs to allure: " + e.getMessage());
        }
    }


    //add screenshot to allure
    public static void addScreenshotToAllure(String screenName, String screenPath) {
        try {
            Allure.attachment(screenName, Files.newInputStream(new File(screenPath).toPath()));
            LogClass.info("success to add screenshot to allure");
        } catch (Exception e) {
            LogClass.error("failed to add screenshot to allure: " + e.getMessage());
        }
    }

    public static String USER_HOME = System.getProperty("user.home");
    public static String USER_DIR = System.getProperty("user.dir");
    public static String ALLURE_BIN = USER_HOME + File.separator + ".m2" + File.separator + "repository" + File.separator + "allure" + File.separator + "allure-2.36.0" + File.separator + "bin" + File.separator + "allure";
    public static String ALLURE_RESULT_PATH = USER_DIR + File.separator + "test-output/allure-results/";
    public static String ALLURE_REPORT_PATH = USER_DIR + File.separator + "test-output/allure-report/";




//    // generate allure
//    public static void generateAllure() {
//        String AllureWin = ALLURE_BIN + ".bat";
//        if (Objects.requireNonNull(getPropertyKey("os.name")).contains("Wind")) {
//            executeCommand(AllureWin,"generate", ALLURE_RESULT_PATH, "-o", ALLURE_REPORT_PATH, "--clean", "--single-file");
//            logClass.info("Successfully to generate allure on windows...");
//        } else if (System.getProperty("os.name").contains("mac")) {
//            executeCommand(ALLURE_BIN, "generate", ALLURE_RESULT_PATH, "-o", ALLURE_REPORT_PATH, "--clean", "--single-file");
//            logClass.info("Successfully to generate allure on Mac...");
//        } else {
//            logClass.info("OS not support...");
//        }
//    }


    //generate allure report
    public static void generateAllure() {
        String windowsBat = ALLURE_BIN + ".bat";
        if (System.getProperty("os.name").contains("Win")) {
            executeCommand(windowsBat,"generate",ALLURE_RESULT_PATH,"-o ",ALLURE_REPORT_PATH," --clean","--single-file");
            LogClass.info("allure report generated successfully on Windows OS");
        } else if (System.getProperty("os.name").contains("Lin") || System.getProperty("os.name").contains("Mac")) {
            executeCommand(ALLURE_BIN,"generate",ALLURE_RESULT_PATH,"-o",ALLURE_REPORT_PATH," --clean","--single-file");
            LogClass.info("allure report generated successfully on Linux/Mac OS");
        } else {
            LogClass.error("unsupported OS for allure report generation");
        }
    }


    //open allure report
public static void openAllureReport() {
    String AllureIndex = ALLURE_REPORT_PATH +File.separator+ "index.html";
    if (Objects.equals(getPropertyKey("openAllure"), "true")) {
        if (Objects.requireNonNull(getPropertyKey("os.name")).contains("win")) {
            executeCommand("open", AllureIndex);
            LogClass.info("Successfully to open allure on windows...");
        } else {
            executeCommand("cmd", "/c", "start", AllureIndex);
            LogClass.info("Successfully to open allure on Mac...");
        }


    } else {
        LogClass.info("open allure automatic not support change the value in property file");
    }
}




}
