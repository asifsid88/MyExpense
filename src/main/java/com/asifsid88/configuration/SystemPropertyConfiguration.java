package com.asifsid88.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by mhussaa on 4/30/17.
 */
@Component
@Log4j2
public class SystemPropertyConfiguration {

    /*
        Read the environment name from System Property or via -Dvariable to load the environment
        Default is set to load `dev` environment
     */
    @Value("#{systemProperties['env'] ?: 'dev'}")
    private String environment;

    @Bean
    public SystemPropertyConfiguration setSystemPropertyConfiguration() {
        log.info("Loading Environment:{} ", environment);
        final Properties systemProperties = System.getProperties();

        /*
            Based on the value passed, it will check and pick up corresponding properties file
         */
        String fileName = "properties/" + environment + ".properties";

        try {
            log.info("Loading properties file:{} ", fileName);

            /*
                Load all the properties or configuration from properties file to System Properties
             */
            systemProperties.load(getClass().getClassLoader().getResourceAsStream(fileName));
            log.info("System property loaded for Environment:{}", environment);
        } catch (Exception e) {
            log.error("Failed to load {}.properties file", environment, e);
        }

        return this;
    }
}
