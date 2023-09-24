package br.com.sellbuy.apisellandbuy.repositories;

import br.com.sellbuy.apisellandbuy.entities.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale,Integer> {
}
