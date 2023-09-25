package br.com.sellbuy.apisellandbuy.projections;

import br.com.sellbuy.apisellandbuy.entities.Buy;
import br.com.sellbuy.apisellandbuy.entities.Historic;
import br.com.sellbuy.apisellandbuy.entities.Sale;
import br.com.sellbuy.apisellandbuy.entities.*;

import java.util.List;
import java.util.Optional;

public interface UserProjection {

    Iterable<Historic> historicalList();

    User buyCurrency(String currency, Integer id);

    User saleCurrency(String currency, Integer id);

    void saveUser(User user);

    public Historic historicUser(Integer id);

    public Optional<User> userById(Integer id);

    public List<User> userList();

}
