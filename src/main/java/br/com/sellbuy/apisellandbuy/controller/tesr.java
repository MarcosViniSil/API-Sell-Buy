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

    @PostMapping("/test/{a}")
    public User test(@PathVariable String a, @RequestBody User user){
        return historicService.saleCurrency(a,user);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
        historicService.saveUser(user);
    }
    @PostMapping("/buy/{a}")
    public User buy(@PathVariable String a, @RequestBody User user){
        return historicService.buyCurrency(a,user);
    }
    @GetMapping("/user")
    public Iterable<User> userGet(@RequestParam Iterable<Integer> id){
        return historicService.userList(id);
    }
}
