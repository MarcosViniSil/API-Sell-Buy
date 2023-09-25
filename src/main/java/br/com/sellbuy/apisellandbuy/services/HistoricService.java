package br.com.sellbuy.apisellandbuy.services;

import br.com.sellbuy.apisellandbuy.entities.*;
import br.com.sellbuy.apisellandbuy.projections.CodeApiProjection;
import br.com.sellbuy.apisellandbuy.projections.MercadoBitcoinCurrencyApiProjection;
import br.com.sellbuy.apisellandbuy.projections.UserProjection;
import br.com.sellbuy.apisellandbuy.repositories.BuyRepository;
import br.com.sellbuy.apisellandbuy.repositories.HistoricRepository;
import br.com.sellbuy.apisellandbuy.repositories.SaleRepository;
import br.com.sellbuy.apisellandbuy.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sellbuy.apisellandbuy.entities.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class HistoricService implements UserProjection {

    @Autowired
    private HistoricRepository historicRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MercadoBitcoinCurrencyApiProjection currencyApiProjection;

    @Autowired
    private CodeApiProjection codeApiProjection;




    @Override
    public Iterable<Historic> historicalList() {

        return historicRepository.findAll();
    }



    @Override
    public Historic buyCurrency(String currency,User user) {
        boolean userExists=userRepository.existsById(user.getId());
        if(userExists) {
            if (currency != null) {
                try {
                    Historic historic=new Historic();
                    String code =generatedCode().getString();
                    Date dataSail=new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    String priceCurrency = getCurrency(currency).getTicker().getLast();
                    Sale sale=new Sale(code,dataSail,currency,priceCurrency);
                    historic.setSale(sale);
                    historicRepository.save(historic);
                    return historic;

                } catch (JsonProcessingException e) {
                    System.out.println("Exception JsonProcessingException line xx");
                }

            }else{
                //exit
            }
        }else{
            //TODO save user
        }
        return null;

    }

    @Override
    public void saleCurrency(String currency, User user) {

    }

    @Override
    public Iterable<Sale> saleList() {
        return null;
    }

    @Override
    public Iterable<Buy> buyList() {
        return null;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }


    private Currency getCurrency(String a) throws JsonProcessingException {
        String json=currencyApiProjection.getCurrency(a,"ticker");
        ObjectMapper objectMapper = new ObjectMapper();
        Currency currency = objectMapper.readValue(json, Currency.class);
        return currency;
    }
    private Codes generatedCode() throws JsonProcessingException {
        String json= codeApiProjection.getCode(25,1);
        ObjectMapper objectMapper = new ObjectMapper();
        Codes currency = objectMapper.readValue(json, Codes.class);
        return currency;
    }
}
