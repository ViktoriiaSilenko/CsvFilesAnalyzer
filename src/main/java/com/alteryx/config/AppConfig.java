package com.alteryx.config;

import com.alteryx.beans.utils.FileReader;
import com.alteryx.beans.utils.IFileReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author imssbora
 */
@Configuration
@ComponentScan(basePackages="com.alteryx.beans")
public class AppConfig {
    @Bean
    public IFileReader getIFileReader() {
        return new FileReader();
    }

}