package br.com.sellbuy.apisellandbuy.services;

import br.com.sellbuy.apisellandbuy.entities.*;
import br.com.sellbuy.apisellandbuy.projections.CodeApiProjection;
import br.com.sellbuy.apisellandbuy.projections.MercadoBitcoinCurrencyApiProjection;
import br.com.sellbuy.apisellandbuy.projections.UserProjection;
import br.com.sellbuy.apisellandbuy.repositories.BuyRepository;
import br.com.sellbuy.apisellandbuy.repositories.HistoricRepository;
import br.com.sellbuy.apisellandbuy.repositories.SaleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricService implements UserProjection {

    @Autowired
    private HistoricRepository historicRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    private MercadoBitcoinCurrencyApiProjection currencyApiProjection;

    @Autowired
    private CodeApiProjection codeApiProjection;

    @Override
    public Iterable<Historic> historicalList() {
        return null;
    }

    @Override
    public void buyCurrency(String currency) {

    }
    public Currency testApiCurrency(String a,String b) throws JsonProcessingException {
        String json=currencyApiProjection.getCurrency(a,b);
        ObjectMapper objectMapper = new ObjectMapper();
        Currency currency = objectMapper.readValue(json, Currency.class);
        return currency;
    }
    public Codes testApiCode(Integer a,Integer b) throws JsonProcessingException {
        String json= codeApiProjection.gerCode(a,b);
        ObjectMapper objectMapper = new ObjectMapper();
        Codes currency = objectMapper.readValue(json, Codes.class);
        return currency;
    }

    @Override
    public void saleCurrency(String currency) {

    }

    @Override
    public Iterable<Sale> saleList() {
        return null;
    }

    @Override
    public Iterable<Buy> buyList() {
        return null;
    }
}
