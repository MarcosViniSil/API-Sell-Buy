package br.com.sellbuy.apisellandbuy.services;

import br.com.sellbuy.apisellandbuy.entities.*;
import br.com.sellbuy.apisellandbuy.projections.CodeApiProjection;
import br.com.sellbuy.apisellandbuy.projections.CoinCurrencyApiProjection;
import br.com.sellbuy.apisellandbuy.projections.UserProjection;
import br.com.sellbuy.apisellandbuy.repositories.BuyRepository;
import br.com.sellbuy.apisellandbuy.repositories.HistoricRepository;
import br.com.sellbuy.apisellandbuy.repositories.SaleRepository;
import br.com.sellbuy.apisellandbuy.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
    private CoinCurrencyApiProjection currencyApiProjection;

    @Autowired
    private CodeApiProjection codeApiProjection;


    @Override
    public Iterable<Historic> historicalList() {

        return historicRepository.findAll();
    }

    @Override
    public List<User> userList() {

        return userRepository.findAll();
    }

    @Override
    public Optional<User> userById(Integer id) {

        return userRepository.findById(id);
    }

    @Override
    public Historic historicUser(Integer id) {
        Optional<User> userByFind = userRepository.findById(id);
        User user = userByFind.get();
        return user.getHistoric();
    }


    @Override
    public User saleCurrency(String currency, Integer id) {
        Optional<User> userByFind = userRepository.findById(id);
        User user = userByFind.get();
        if (user.getId() != null) {
            if (currency != null) {
                try {

                    Historic historic = user.getHistoric();
                    if (historic == null) {
                        historic = new Historic();
                        user.setHistoric(historic);
                        historic.setUser(user);
                    }

                    String code = generatedCode().getString();
                    Date dataSale = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    String priceCurrency = getCurrency(currency).getTicker().getLast();
                    Sale sale = new Sale(code, dataSale, currency, priceCurrency);


                    user.getHistoric().setSale(sale);
                    user.getHistoric().setHistoricCode(generatedCode().getString());
                    user.getHistoric().setDateAccess(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
                    sale.setHistoric(historic);
                    historic.setSale(sale);
                    user.setHistoric(historic);
                    historic.setUser(user);
                    historicRepository.save(historic);
                    saleRepository.save(sale);
                    userRepository.save(user);

                    return user;

                } catch (JsonProcessingException e) {
                    System.out.println("Exception JsonProcessingException line xx");
                }

            } else {
                //exit
            }
        } else {
            saveUser(user);
        }
        return null;

    }

    @Override
    public User buyCurrency(String currency, Integer id) {
        Optional<User> userByFind = userRepository.findById(id);
        User user = userByFind.get();

        if (user.getId() != null) {
            if (currency != null) {
                try {
                    Historic historic = user.getHistoric();


                    if (historic == null) {
                        historic = new Historic();
                        user.setHistoric(historic);
                        historic.setUser(user);
                    }
                    String code = generatedCode().getString();
                    Date dataBuy = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    String priceCurrency = getCurrency(currency).getTicker().getLast();
                    Buy buy = new Buy(code, dataBuy, priceCurrency, currency);


                    user.getHistoric().setBuy(buy);
                    user.getHistoric().setHistoricCode(generatedCode().getString());
                    user.getHistoric().setDateAccess(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
                    buy.setHistoric(historic);
                    historic.setBuy(buy);
                    user.setHistoric(historic);
                    historic.setUser(user);
                    historicRepository.save(historic);
                    buyRepository.save(buy);
                    userRepository.save(user);
                    return user;

                } catch (JsonProcessingException e) {
                    System.out.println("Exception JsonProcessingException line xx");
                }

            } else {
                //exit
            }
        } else {
            saveUser(user);
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }


    private Currency getCurrency(String a) throws JsonProcessingException {
        String json = currencyApiProjection.getCurrency(a, "ticker");
        ObjectMapper objectMapper = new ObjectMapper();
        Currency currency = objectMapper.readValue(json, Currency.class);
        return currency;
    }

    private Codes generatedCode() throws JsonProcessingException {
        String json = codeApiProjection.getCode(25, 1);
        ObjectMapper objectMapper = new ObjectMapper();
        Codes currency = objectMapper.readValue(json, Codes.class);
        return currency;
    }
}
