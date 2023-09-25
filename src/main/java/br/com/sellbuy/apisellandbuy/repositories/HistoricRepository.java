package br.com.sellbuy.apisellandbuy.repositories;

import br.com.sellbuy.apisellandbuy.entities.Historic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricRepository extends JpaRepository<Historic, Integer> {
}
