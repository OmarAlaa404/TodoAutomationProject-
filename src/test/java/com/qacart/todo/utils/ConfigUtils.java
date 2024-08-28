package com.qacart.todo.utils;

import java.util.Properties;

/**
 * ConfigUtils class manages loading and accessing configuration properties.
 * It follows the Singleton pattern to ensure that only one instance of the configuration is loaded.
 */
public class ConfigUtils {

    private static ConfigUtils configUtils;
    private static Properties properties;

    /**
     * Private constructor to load the appropriate properties file based on the environment.
     * The environment is determined by the 'env' system property.
     */
    private ConfigUtils() {
        String env = System.getProperty("env", "TEST").toUpperCase();  // Default to "TEST" and convert to uppercase
        switch (env) {
            case "PRODUCTION":
                properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/application-Production.properties");
                break;
            case "TEST":
                properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/application-test.properties");
                break;
            default:
                throw new RuntimeException("Environment is not supported: " + env);
        }
    }

    /**
     * Gets the singleton instance of ConfigUtils.
     *
     * @return ConfigUtils instance.
     */
    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            synchronized (ConfigUtils.class) {
                if (configUtils == null) {  // Double-checked locking
                    configUtils = new ConfigUtils();
                }
            }
        }
        return configUtils;
    }

    /**
     * Gets the base URL from the configuration file.
     *
     * @return base URL.
     * @throws RuntimeException if the 'baseURL' property is not found.
     */
    public String getBaseURL() {
        return getProperty("baseURL", "Could not find the 'baseURL' property in the configuration file.");
    }

    /**
     * Gets the email from the configuration file.
     *
     * @return email.
     * @throws RuntimeException if the 'email' property is not found.
     */
    public String getEmail() {
        return getProperty("email", "Could not find the 'email' property in the configuration file.");
    }

    /**
     * Gets the password from the configuration file.
     *
     * @return password.
     * @throws RuntimeException if the 'password' property is not found.
     */
    public String getPassword() {
        return getProperty("password", "Could not find the 'password' property in the configuration file.");
    }

    /**
     * A helper method to get a property value from the properties file.
     *
     * @param key the key of the property.
     * @param errorMessage the error message to display if the property is not found.
     * @return the property value.
     * @throws RuntimeException if the property is not found.
     */
    private String getProperty(String key, String errorMessage) {
        String prop = properties.getProperty(key);
        if (prop == null) {
            throw new RuntimeException(errorMessage);
        }
        return prop;
    }
}
