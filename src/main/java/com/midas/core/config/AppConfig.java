package com.midas.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // This creates a "singleton" RestTemplate that we can inject anywhere
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}