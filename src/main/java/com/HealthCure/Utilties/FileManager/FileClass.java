package com.HealthCure.Utilties.FileManager;

import com.HealthCure.Utilties.LogManager.LogClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileClass {


    //get last file
    public static File getLastFile(String filePath)
    {
        File file = new File(filePath);
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        return files[0];
    }



    //delete files
    public static void deleteFiles(File filePath)
    {
        try {
            FileUtils.deleteQuietly(filePath);
            LogClass.info("deleted files from path: "+filePath.getAbsolutePath());
        }catch (Exception e)
        {
            LogClass.error("failed to delete files from path: "+filePath.getAbsolutePath()+" error: "+e.getMessage());
        }
    }








}
