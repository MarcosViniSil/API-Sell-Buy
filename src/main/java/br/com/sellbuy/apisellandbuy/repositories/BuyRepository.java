package br.com.sellbuy.apisellandbuy.repositories;

import br.com.sellbuy.apisellandbuy.entities.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends JpaRepository<Buy,Integer> {
}
