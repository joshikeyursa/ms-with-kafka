package com.kjoshi.learning.ms.mswithkafka.service;

import com.kjoshi.learning.ms.mswithkafka.bean.crypto.response.CryptoDataResponse;
import com.kjoshi.learning.ms.mswithkafka.bean.crypto.response.CryptoRateResponse;
import com.kjoshi.learning.ms.mswithkafka.client.CoinGeckoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CoinGeckoService {
    @Autowired
    CoinGeckoClient client;

    private static final Logger logger = LoggerFactory.getLogger(CoinGeckoService.class);

    public Mono<String> pingServer(){
        return client.pingServer();
    }

    public CompletableFuture<CryptoDataResponse> getBinanceTickerData(String tickerId){
        return client.getBinanceData(tickerId).toFuture().thenApply(x->{
            logger.info("Processing Response.");
            CryptoDataResponse response = new CryptoDataResponse();
            List<CryptoRateResponse> rateResponses = new ArrayList<>();
            response.setName(x.getName());
            x.getTickers().stream().filter(tikerData->"GREEN".equalsIgnoreCase(tikerData.getTrust_score())).forEach(ticker->{
                CryptoRateResponse rate = new CryptoRateResponse();
                rate.setBase(ticker.getBase());
                rate.setTarget(ticker.getTarget());
                rate.setConversionRate(ticker.getLast());
                rateResponses.add(rate);
            });
            response.setRate(rateResponses);
            return response;
        }).thenCombine(CompletableFuture.supplyAsync(()->"Provided by CoinGecko"),(res1,res2)->{
            logger.info("Combining response..nothing major for now..");
            return res1;
        });
    }
}
