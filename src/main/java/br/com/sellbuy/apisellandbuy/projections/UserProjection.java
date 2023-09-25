package br.com.sellbuy.apisellandbuy.projections;

import br.com.sellbuy.apisellandbuy.entities.Buy;
import br.com.sellbuy.apisellandbuy.entities.Currency;
import br.com.sellbuy.apisellandbuy.entities.Historic;
import br.com.sellbuy.apisellandbuy.entities.Sale;
import br.com.sellbuy.apisellandbuy.entities.*;

public interface UserProjection {

    Iterable<Historic> historicalList();

    User buyCurrency(String currency,Integer id);

    User saleCurrency(String currency,Integer id);

    Iterable<Sale> saleList();

    Iterable<Buy> buyList();

    void saveUser(User user);

}
