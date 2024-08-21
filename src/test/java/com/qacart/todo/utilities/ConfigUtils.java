package com.qacart.todo.utilities;

import java.util.Properties;

public class ConfigUtils {

    private static ConfigUtils configUtils;
    private static Properties properties;

    private ConfigUtils() {
        properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/application-test.properties");
    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseURL() {
        String prop = properties.getProperty("baseURL");
        if (prop == null) {
            throw new RuntimeException("Could not find the 'baseURL' property in the configuration file.");
        }
        return prop;
    }

    public String getEmail() {
        String prop = properties.getProperty("email");
        if (prop == null) {
            throw new RuntimeException("Could not find the 'email' property in the configuration file.");
        }
        return prop;
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop == null) {
            throw new RuntimeException("Could not find the 'password' property in the configuration file.");
        }
        return prop;
    }
}
