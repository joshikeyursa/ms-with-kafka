package com.kjoshi.learning.ms.mswithkafka.config;

import com.kjoshi.learning.ms.mswithkafka.bean.crypto.response.CryptoListResponse;
import com.kjoshi.learning.ms.mswithkafka.client.CoinGeckoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppScheduler {

    @Autowired
    CoinGeckoClient client;


    private static final Logger logger = LoggerFactory.getLogger(AppScheduler.class);

    public AppScheduler(CoinGeckoClient client){
        this.client = client;
    }

    @Scheduled(cron = "0 0/5 * * * *")
    public void storeCryptorList(){
        logger.info("Will load Crypto data");
        List<CryptoListResponse> tickerList = new ArrayList<>();
        client.getCryptoList().toStream().forEach(x-> {
                logger.info("{} {} {}",x.getName(),x.getId(),x.getSymbol());
                tickerList.add(x);
        });
        logger.info("{} coins in total",tickerList.size());
    }
}
