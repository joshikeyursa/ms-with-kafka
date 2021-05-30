package com.kjoshi.learning.ms.mswithkafka.bean.downstream.coingecko.response;

import java.util.List;

public class BinanceCryptoResponse {
    private String name;
    private List<BinanceTickerResponse> tickers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BinanceTickerResponse> getTickers() {
        return tickers;
    }

    public void setTickers(List<BinanceTickerResponse> tickers) {
        this.tickers = tickers;
    }
}
