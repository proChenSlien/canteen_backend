package com.cp.service.impl;

import com.cp.domain.MidShoppingGoods;
import com.cp.repository.MidShopGoodsRepository;
import com.cp.service.MidShopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:00
 */
@Service
public class MidShopGoodsServiceImpl extends AbstractGenericServiceImpl<MidShoppingGoods, Long> implements MidShopGoodsService {
    @Autowired
    private MidShopGoodsRepository repository;
    @Override
    public JpaRepository<MidShoppingGoods, Long> getRepository() {
        return repository;
    }
}
