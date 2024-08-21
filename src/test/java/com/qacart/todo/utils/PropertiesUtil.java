package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

/**
 * PropertiesUtil class provides utility methods for loading properties from a file.
 */
public class PropertiesUtil {

    /**
     * Loads properties from a specified file path.
     * @param filePath Path to the properties file.
     * @return Properties object containing loaded properties.
     * @throws IllegalArgumentException if the file path is null or empty.
     * @throws RuntimeException if the file is not found or an error occurs while loading.
     */
    public static Properties loadProperties(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path must not be null or empty");
        }

        File file = new File(filePath);
        try (InputStream inputStream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error while loading properties from file: " + filePath, e);
        }
    }
}
