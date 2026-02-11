package com.ui.pojo;

import java.util.Map;

public class config {

    Map<String, Environment> environment;

    public Map<String, Environment> getEnvironment() {
        return environment;
    }

    public void setenvironment(Map<String, Environment> environment) {
        this.environment = environment;
    }
}
