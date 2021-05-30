package com.kjoshi.learning.ms.mswithkafka.bean.downstream.coingecko.response;

public class BinanceTickerResponse {
    private String base;
    private String target;
    private Double last;
    private Double volume;
    private String trust_score;

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

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getTrust_score() {
        return trust_score;
    }

    public void setTrust_score(String trust_score) {
        this.trust_score = trust_score;
    }
}
