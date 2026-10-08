package com.HealthCure.Utilties.DataManager;

import com.HealthCure.Utilties.LogManager.LogClass;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class ReadJsonClass {

    public String FileName ;
    public String filePath = System.getProperty("user.dir") + File.separator + "src/test/resources/test-data/";
    public static String jsonValues ;


    public ReadJsonClass(String fileName) {
        try {
            this.FileName = fileName;
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filePath + FileName + ".json"));
            jsonValues = jsonObject.toJSONString();
            LogClass.info("read json file: " + filePath + FileName + ".json successfully");
        } catch (Exception e) {
            LogClass.error("failed to read json file: " + filePath + FileName + ".json error: " + e.getMessage());
        }
    }


    public static String getJsonKey(String key)
    {
        try {
            String jsonData="";
            jsonData = JsonPath.read(jsonValues,key);
            return jsonData;
        }catch (Exception e)
        {
            LogClass.error("failed to get json key: "+key+" error: "+e.getMessage());
            return "0";
        }
    }



}
