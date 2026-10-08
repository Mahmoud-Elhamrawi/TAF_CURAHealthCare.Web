package com.HealthCure.Utilties.DataManager;

import com.HealthCure.Utilties.LogManager.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;

public class ReadPropertyClass {
    public static final  String PROPERT_PATH= System.getProperty("user.dir")+File.separator +"/";
     static Properties properties = new Properties();

     public static Properties loadProperty()
     {
         try {
             Collection<File>fileCollection;
             fileCollection = FileUtils.listFiles(new File(PROPERT_PATH), new String[]{"properties"}, true);
             fileCollection.forEach(file -> {
                 try {
                     properties.load(new FileInputStream(file));
                     properties.putAll(System.getProperties());
                     System.getProperties().putAll(properties);
                     LogClass.info("loaded property file: "+file.getAbsolutePath());
                 } catch (Exception e) {
                     LogClass.error("failed to load property file: "+file.getAbsolutePath()+" error: "+e.getMessage());
                 }
             });
                return properties;
         }catch (Exception e)
         {
             LogClass.error("failed to load property file: "+PROPERT_PATH+" error: "+e.getMessage());
             return null;
         }
     }


    public static String getPropertyKey(String key)
    {
        try {
            String value = System.getProperty(key);
            LogClass.info("get property key: "+key+" value: "+value);
            return value;
        }catch (Exception e)
        {
            LogClass.error("failed to get property key: "+key+" error: "+e.getMessage());
            return null;
        }
    }






}
