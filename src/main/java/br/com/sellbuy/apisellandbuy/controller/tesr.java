package br.com.sellbuy.apisellandbuy.controller;

import br.com.sellbuy.apisellandbuy.entities.Codes;
import br.com.sellbuy.apisellandbuy.entities.Currency;
import br.com.sellbuy.apisellandbuy.entities.Historic;
import br.com.sellbuy.apisellandbuy.entities.User;
import br.com.sellbuy.apisellandbuy.services.HistoricService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class tesr {

    @Autowired
    private HistoricService historicService;

    @PostMapping("/test/{a}/{user}")
    public Historic test(@PathVariable String a, @RequestBody User user){
        return historicService.buyCurrency(a,user);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
        historicService.saveUser(user);
    }
}
