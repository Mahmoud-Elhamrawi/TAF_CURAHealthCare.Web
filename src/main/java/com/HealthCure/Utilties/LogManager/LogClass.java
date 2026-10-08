package com.HealthCure.Utilties.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class LogClass {


    public static final String LOG_PATH=System.getProperty("user.dir")+ File.separator+"test-output/Logs/";


    public static Logger getLogger()
    {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }


    //info
    public static void info(String ...message)
    {
        getLogger().info(String.join("",message));
    }

    //error
    public static void error(String ...message)
    {
        getLogger().error(String.join("",message));
    }

    //debug
    public static void debug(String ...message)
    {
        getLogger().debug(String.join("",message));
    }

    //warn
    public static void warn(String ...message)
    {
        getLogger().warn(String.join("",message));
    }







}
