package com.utillity;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Environment;
import com.ui.pojo.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtillity {

    public static Environment readJSON(Env env) {

        Gson gson = new Gson();
        File jsonfile = new File(System.getProperty("user.dir") + "/config/config.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        config config = gson.fromJson(fileReader, config.class);
        Environment environment = config.getEnvironment().get("QA");
        return environment;
    }
}
