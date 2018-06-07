package com.cp.service;

import com.cp.domain.GoodsType;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:46
 */
public interface GoodsTypeService extends BaseService<GoodsType, Long>{
    void updateStaById(String id);
}
