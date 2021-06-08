package com.kjoshi.learning.ms.mswithkafka.client;

import com.kjoshi.learning.ms.mswithkafka.bean.crypto.response.CryptoListResponse;
import com.kjoshi.learning.ms.mswithkafka.bean.downstream.coingecko.response.BinanceCryptoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CoinGeckoClient {

    @Value("${downstream.coingecko.url}")
    private String url;

    @Autowired
    WebClient webClient;

    private static final Logger logger = LoggerFactory.getLogger(CoinGeckoClient.class);

    public CoinGeckoClient(WebClient webClient){
        logger.info("Initializing CoinGeckoClient");
        this.webClient = webClient;
    }

    public Mono<String> pingServer(){
        logger.info("Pinging Server {} ",url);
        return webClient.get().uri(url+"/v3/ping").exchangeToMono(
                clientResponse -> {
                    if(clientResponse.statusCode().is2xxSuccessful())
                        return clientResponse.bodyToMono(String.class);
                    else
                        return Mono.just("ERROR");
                });
    }

    public Mono<BinanceCryptoResponse> getBinanceData(String ticker){
        String dataUrl = url+"/v3/coins/"+ticker+"/tickers?exchange_ids=binance&page=1";
        logger.info("Getting data for {} from Binance",dataUrl);
        return webClient.get().uri(dataUrl).exchangeToMono(clientResponse -> {
            if(clientResponse.statusCode().is2xxSuccessful()){
                logger.info("Response received..");
                return clientResponse.bodyToMono(BinanceCryptoResponse.class);
            }
            else{
                logger.info("Error received {}",clientResponse.statusCode());
                return Mono.just(new BinanceCryptoResponse());
            }
        });
    }

    public Flux<CryptoListResponse> getCryptoList(){
        String dataUrl = url +"/v3/coins/list";
        logger.info("Getting list from {}",url);
        return webClient.get().uri(dataUrl).exchangeToFlux(clientResponse -> {
           if(clientResponse.statusCode().is2xxSuccessful()){
               logger.info("Response Received.");
               return clientResponse.bodyToFlux(CryptoListResponse.class);
           }else{
               logger.info("Error occurred.");
               return Flux.just(new CryptoListResponse());
           }
        });
    }
}
