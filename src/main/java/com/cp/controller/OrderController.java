package com.cp.controller;

import com.cp.domain.Order;
import com.cp.service.BaseService;
import com.cp.service.OrderService;
import com.cp.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:23
 */
@RestController
@RequestMapping("/manage/order")
public class OrderController extends BaseController<Order, Long>{
    @Autowired
    private OrderService orderService;
    @Override
    protected BaseService<Order, Long> getService() {
        return orderService;
    }

    @ApiOperation("删除商品")
    @GetMapping("/deleteOrder/{id}")
    public Result delete(@PathVariable String id) {
        orderService.updateStaById(id);
        return Result.createBySuccess("删除成功");
    }
}
