package com.kjoshi.learning.ms.mswithkafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class HealthService {

    private static final Logger logger = LoggerFactory.getLogger(HealthService.class);

    public CompletableFuture<String> getHealthStatus(){
        return CompletableFuture.supplyAsync(()->{
            logger.info("In health check service");
            return "SUCCESS";
        });
    }
}
