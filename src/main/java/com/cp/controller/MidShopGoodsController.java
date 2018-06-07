package com.cp.controller;

import com.cp.domain.MidShoppingGoods;
import com.cp.service.BaseService;
import com.cp.service.MidShopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:56
 */
@RestController
@RequestMapping("/manage/shopGoods")
public class MidShopGoodsController extends BaseController<MidShoppingGoods, Long> {
    @Autowired
    private MidShopGoodsService midShopGoodsService;
    @Override
    protected BaseService<MidShoppingGoods, Long> getService() {
        return midShopGoodsService;
    }
}
