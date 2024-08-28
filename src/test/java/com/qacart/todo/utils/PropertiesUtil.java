package com.qacart.todo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesUtil class provides utility methods for loading properties from a file.
 * This class is designed to handle loading properties files in a reliable and consistent manner.
 */
public class PropertiesUtil {

    /**
     * Loads properties from a specified file path.
     *
     * @param filePath the path to the properties file.
     * @return a Properties object containing the loaded properties.
     * @throws IllegalArgumentException if the file path is null or empty.
     * @throws RuntimeException if the file is not found or an error occurs while loading.
     */
    public static Properties loadProperties(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path must not be null or empty");
        }

        try (InputStream inputStream = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Error while loading properties from file: " + filePath, e);
        }
    }
}
