package com.igm.app01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** The example project using the MAVEN profiles. */
public class App {

    /**
     * Main method.
     *
     * @param args The argument from command line.
     */
    public static void main(final String[] args) {
        final App app = new App();
        final Properties properties = app.loadProperties();
        if (properties != null) {
            properties.forEach((v, k) -> System.out.println(String.format("%s: %s", v, k)));
        } else {
            System.err.println("Faild to load properties file: configuration.properties");            
        }
    }

    private Properties loadProperties() {
        final Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("configuration.properties")) {
            properties.load(inputStream);
        } catch (final IOException e) {            
            return null;
        }
        return properties;
    }
}