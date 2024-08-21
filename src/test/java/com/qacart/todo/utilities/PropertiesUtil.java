package com.qacart.todo.utilities;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {

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
