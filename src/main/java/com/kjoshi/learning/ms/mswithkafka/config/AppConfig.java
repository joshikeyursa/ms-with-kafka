package com.kjoshi.learning.ms.mswithkafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    private final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public WebClient buildWebClient(){
        logger.info("Building WebClient");
        WebClient client = WebClient.builder().build();
        logger.info("WebClient Ready");
        return client;
    }
}
