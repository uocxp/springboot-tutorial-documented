package com.documented.spring.tutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The @Configuration annotation tells Spring that it’s a configuration class. 
 * When the application context is built, the methods that are annotated with @Bean 
 * inside such configuration classes are called, and their return values are stored as beans. 
 * The name of the methods become the names of the beans by default.
 *
 */
@Configuration
public class MailConfig {
    @Bean
    public MailSender thirdPartyClassMailSender() {
        return new ThirdPartyClassMailSender();
    }

   
}