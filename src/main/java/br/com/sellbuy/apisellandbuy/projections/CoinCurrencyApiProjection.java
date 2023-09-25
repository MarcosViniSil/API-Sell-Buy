package br.com.sellbuy.apisellandbuy.projections;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mercadobitcoin", url = "https://www.mercadobitcoin.net/api")
public interface CoinCurrencyApiProjection {

    @GetMapping("/{currency}/{method}/")
    String getCurrency(
            @PathVariable("currency") String currency,
            @PathVariable("method") String method
    );
}
