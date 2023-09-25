package br.com.sellbuy.apisellandbuy.controller;

import br.com.sellbuy.apisellandbuy.entities.Codes;
import br.com.sellbuy.apisellandbuy.entities.Currency;
import br.com.sellbuy.apisellandbuy.entities.Historic;
import br.com.sellbuy.apisellandbuy.entities.User;
import br.com.sellbuy.apisellandbuy.services.HistoricService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class tesr {

    @Autowired
    private HistoricService historicService;

    @PostMapping("/sale/{a}/{id}")
    public User test(@PathVariable String a, @PathVariable Integer id){
        return historicService.saleCurrency(a,id);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user){

        historicService.saveUser(user);
    }
    @PostMapping("/buy/{a}/{id}")
    public User buy(@PathVariable String a, @PathVariable Integer id){

        return historicService.buyCurrency(a,id);
    }
    @GetMapping("/fetch/{id}")
    public Optional<User> userGet(@PathVariable("id") Integer id){

        return historicService.userById(id);
    }
    @GetMapping("/historic/{id}")
    public Historic historicUser(@PathVariable("id") Integer id){

        return historicService.historicUser(id);
    }
    @GetMapping("/fetch")
    public List<User> listUsers(){
        return historicService.userList();
    }

}
