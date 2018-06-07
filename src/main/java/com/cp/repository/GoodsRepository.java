package com.cp.repository;

import com.cp.domain.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:27
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>,QuerydslPredicateExecutor<Goods> {

    @Modifying
    @Query(value = "update Goods set valid = 0 where id = ?1")
    void updateStaById(String id);

    @Query(value = "select new com.cp.dto.vo.GoodsVo(g.id, g.goodsName, t.typeName, g.price, g.img, g.remark, g.stock, g.volumeDay, " +
            "g.volumeMonth, g.volumeYear, g.state, g.valid) from Goods g " +
            "left join GoodsType t on t.id = g.typeId" )
    Page getGoodsList(Pageable pageable);
}
