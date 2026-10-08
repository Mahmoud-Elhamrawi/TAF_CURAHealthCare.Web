package com.HealthCure.Utilties.Commandmanager;

import com.HealthCure.Utilties.LogManager.LogClass;

public class CommandClass {

    public static void executeCommand(String... command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
            LogClass.info("executed command: " + String.join(" ", command));
        } catch (Exception e) {
            LogClass.error("failed to execute command: " + String.join(" ", command) + " error: " + e.getMessage());
        }


    }


}
