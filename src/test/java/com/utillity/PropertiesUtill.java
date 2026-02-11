package com.utillity;

import com.constants.Env;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtill {

    public static String readProperty(Env env, String propertyName) {
        File propfile = new File(System.getProperty("user.dir") + "/config/" + env + ".properties");
        Properties properties = new Properties();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(propfile);
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(propertyName.toUpperCase());
    }
}
