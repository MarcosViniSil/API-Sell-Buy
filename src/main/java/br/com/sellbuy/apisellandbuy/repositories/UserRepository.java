package br.com.sellbuy.apisellandbuy.repositories;

import br.com.sellbuy.apisellandbuy.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
