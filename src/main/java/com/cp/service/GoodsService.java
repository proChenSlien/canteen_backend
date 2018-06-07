package com.cp.service;

import com.cp.domain.Goods;
import org.springframework.data.domain.Page;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:24
 */
public interface GoodsService extends BaseService<Goods, Long>{

    void updateStaById(String id);

    Page getGoodsList(Integer page, Integer pageSize);
}
