package com.kjoshi.learning.ms.mswithkafka.controller;

import com.kjoshi.learning.ms.mswithkafka.bean.crypto.response.CryptoDataResponse;
import com.kjoshi.learning.ms.mswithkafka.service.CoinGeckoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/crypto")
public class CoinGeckoController {

    private static final Logger logger = LoggerFactory.getLogger(CoinGeckoController.class);

    @Autowired
    private CoinGeckoService coinGeckoService;

    @GetMapping("/health")
    public Mono<String> getHealthCheck(){
        return coinGeckoService.pingServer();
    }

    @GetMapping("/data/{tickerId}")
    public CompletableFuture<CryptoDataResponse> getCryptoData(@PathVariable String tickerId){
        logger.info("Getting data for {} ",tickerId);
        return coinGeckoService.getBinanceTickerData(tickerId);
    }
}
