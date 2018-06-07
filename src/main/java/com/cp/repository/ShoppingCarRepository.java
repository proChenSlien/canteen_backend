package com.cp.repository;

import com.cp.domain.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:42
 */
@Repository
public interface ShoppingCarRepository extends JpaRepository<ShoppingCar, Long>,QuerydslPredicateExecutor<ShoppingCar> {
}
