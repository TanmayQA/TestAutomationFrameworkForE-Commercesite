package com.utillity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    // Global config/ Set up for logger
    // SingleTon Design Pattern -- becoz constructor is private. but object created inside the class

    private LoggerUtility() {
    }

    public static Logger getLogger(Class<?> clazz) {
         Logger logger = null;

        if (logger == null) {
            logger = LogManager.getLogger(clazz);
        }
        return logger;
    }
}