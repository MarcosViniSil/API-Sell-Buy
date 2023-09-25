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

    public Iterable<User> userList(Iterable<Integer> id){
        return userRepository.findAllById(id);
    }




    @Override
    public User saleCurrency(String currency,User user) {
        boolean userExists=userRepository.existsById(user.getId());
        if(userExists) {
            if (currency != null) {
                try {
                    Historic historic = new Historic();
                    String code = generatedCode().getString();
                    Date dataBuy = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    String priceCurrency = getCurrency(currency).getTicker().getLast();
                    Sale sale = new Sale(code, dataBuy, priceCurrency, currency);

                    // Primeiro, salve o histórico
                    historic.setSale(sale);
                    historic.setHistoricCode(generatedCode().getString());
                    historic.setDateAccess(new java.sql.Date(Calendar.getInstance().getTime().getTime()));


                    // Em seguida, configure as associações e salve o resto
                    sale.setHistoric(historic);
                    historic.setSale(sale);
                    user.setHistoric(historic);
                    historicRepository.save(historic);
                    userRepository.save(user);
                    saleRepository.save(sale);

                    return user;

                } catch (JsonProcessingException e) {
                    System.out.println("Exception JsonProcessingException line xx");
                }

            }else{
                //exit
            }
        }else{
            saveUser(user);
        }
        return null;

    }

    @Override
    public User buyCurrency(String currency, User user) {
        boolean userExists=userRepository.existsById(user.getId());
        if(userExists) {
            if (currency != null) {
                try {
                    Historic historic=new Historic();
                    String code =generatedCode().getString();
                    Date dataBuy=new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    String priceCurrency = getCurrency(currency).getTicker().getLast();
                    Buy buy=new Buy(code,dataBuy,priceCurrency,currency);
                    //historicRepository.save(historic);

                    historic.setBuy(buy);
                    historic.setHistoricCode(generatedCode().getString());
                    historic.setDateAccess(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
                    buy.setHistoric(historic);
                    historic.setBuy(buy);
                    user.setHistoric(historic);
                    historicRepository.save(historic);
                    buyRepository.save(buy);

                    userRepository.save(user);
                    return user;

                } catch (JsonProcessingException e) {
                    System.out.println("Exception JsonProcessingException line xx");
                }

            }else{
                //exit
            }
        }else{
            saveUser(user);
        }
        return null;
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
