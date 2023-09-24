package br.com.sellbuy.apisellandbuy.controller;

import br.com.sellbuy.apisellandbuy.entities.Codes;
import br.com.sellbuy.apisellandbuy.entities.Currency;
import br.com.sellbuy.apisellandbuy.services.HistoricService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tesr {

    @Autowired
    private HistoricService historicService;

    @GetMapping("/users/{b}/{c}")
    public Currency buscarTodos(@PathVariable String b,@PathVariable String c) throws JsonProcessingException {
       return historicService.testApiCurrency(b,c);
    }
    @GetMapping("/test2/{b}/{c}")
    public Codes buscar(@PathVariable Integer b, @PathVariable Integer c) throws JsonProcessingException {
        return historicService.testApiCode(b,c);
    }
}
