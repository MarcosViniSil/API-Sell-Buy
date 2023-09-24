package br.com.sellbuy.apisellandbuy.repositories;

import br.com.sellbuy.apisellandbuy.entities.Buy;
import org.springframework.data.repository.CrudRepository;

public interface BuyRepository extends CrudRepository<Buy,Integer> {
}
