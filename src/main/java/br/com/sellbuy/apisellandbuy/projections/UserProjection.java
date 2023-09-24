package br.com.sellbuy.apisellandbuy.projections;

import br.com.sellbuy.apisellandbuy.entities.Buy;
import br.com.sellbuy.apisellandbuy.entities.Historic;
import br.com.sellbuy.apisellandbuy.entities.Sale;

public interface UserProjection {

    Iterable<Historic> historicalList();

    void buyCurrency(String currency);

    void saleCurrency(String currency);

    Iterable<Sale> saleList();

    Iterable<Buy> buyList();

}
