package com.cp.controller;

import com.cp.domain.ShoppingCar;
import com.cp.service.BaseService;
import com.cp.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:34
 */
@RestController
@RequestMapping("/manage/shoppingCar")
public class ShoppingCarController extends BaseController<ShoppingCar, Long>{
    @Autowired
    private ShoppingCarService shoppingCarService;
    @Override
    protected BaseService<ShoppingCar, Long> getService() {
        return shoppingCarService;
    }
}
