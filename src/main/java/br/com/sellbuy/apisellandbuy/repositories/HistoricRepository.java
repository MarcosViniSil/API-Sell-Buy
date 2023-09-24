package br.com.sellbuy.apisellandbuy.repositories;

import br.com.sellbuy.apisellandbuy.entities.Historic;
import org.springframework.data.repository.CrudRepository;

public interface HistoricRepository extends CrudRepository<Historic,Integer> {
}
