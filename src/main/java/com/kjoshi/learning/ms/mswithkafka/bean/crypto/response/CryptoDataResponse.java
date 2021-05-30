package com.kjoshi.learning.ms.mswithkafka.bean.crypto.response;

import java.util.List;

public class CryptoDataResponse {
    private String name;
    private List<CryptoRateResponse> rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CryptoRateResponse> getRate() {
        return rate;
    }

    public void setRate(List<CryptoRateResponse> rate) {
        this.rate = rate;
    }
}
