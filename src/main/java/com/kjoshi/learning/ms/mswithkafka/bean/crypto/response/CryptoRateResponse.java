package com.kjoshi.learning.ms.mswithkafka.bean.crypto.response;

import java.util.List;

public class CryptoRateResponse {
    private String base;
    private String target;
    private Double conversionRate;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
