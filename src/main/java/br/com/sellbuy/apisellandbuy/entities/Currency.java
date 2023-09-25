package br.com.sellbuy.apisellandbuy.entities;


import com.fasterxml.jackson.annotation.JsonProperty;


public class Currency {
    @JsonProperty("ticker")
    private Ticker ticker;

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }


}
