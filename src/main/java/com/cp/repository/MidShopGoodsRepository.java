package com.cp.repository;

import com.cp.domain.MidShoppingGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:07
 */
@Repository
public interface MidShopGoodsRepository extends JpaRepository<MidShoppingGoods, Long>,QuerydslPredicateExecutor<MidShoppingGoods> {
}
