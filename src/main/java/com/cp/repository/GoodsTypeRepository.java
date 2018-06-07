package com.cp.repository;

import com.cp.domain.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:51
 */
@Repository
public interface GoodsTypeRepository extends JpaRepository<GoodsType, Long>,QuerydslPredicateExecutor<GoodsType> {
    @Modifying
    @Query(value = "update GoodsType set valid = 0 where id = ?1")
    void updateStaById(String id);
}
