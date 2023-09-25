package br.com.sellbuy.apisellandbuy.controller;

import br.com.sellbuy.apisellandbuy.entities.Historic;
import br.com.sellbuy.apisellandbuy.entities.User;
import br.com.sellbuy.apisellandbuy.services.HistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiConntroller {

    @Autowired
    private HistoricService historicService;

    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {

        historicService.saveUser(user);
    }

    @PostMapping("/sale/{currentSale}/{idUser}")
    public void sale(@PathVariable String currentSale, @PathVariable Integer idUser) {

        historicService.saleCurrency(currentSale, idUser);
        System.out.println("sale sucess,line 28");
    }

    @PostMapping("/buy/{currentBuy}/{idUser}")
    public void buy(@PathVariable String currentBuy, @PathVariable Integer idUser) {

        historicService.buyCurrency(currentBuy, idUser);
        System.out.println("sale sucess,line 35");
    }

    @GetMapping("/fetch/{id}")
    public Optional<User> userGet(@PathVariable("idUser") Integer idUser) {

        return historicService.userById(idUser);
    }

    @GetMapping("/historic/{id}")
    public Historic historicUser(@PathVariable("idUser") Integer idUser) {

        return historicService.historicUser(idUser);
    }

    @GetMapping("/fetch")
    public List<User> listUsers() {
        return historicService.userList();
    }

}
