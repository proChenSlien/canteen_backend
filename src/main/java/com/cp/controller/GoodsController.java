package com.cp.controller;

import com.cp.domain.Goods;
import com.cp.service.BaseService;
import com.cp.service.GoodsService;
import com.cp.utils.Result;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:21
 */
@RestController
@RequestMapping("/manage/goods")
public class GoodsController extends BaseController<Goods, Long> {
    @Autowired
    private GoodsService goodsService;

    @Override
    protected BaseService<Goods, Long> getService() {
        return goodsService;
    }

    @ApiOperation("删除商品")
    @GetMapping("/deleteGoods/{id}")
    public Result delete(@PathVariable String id) {
        goodsService.updateStaById(id);
        return Result.createBySuccess("删除成功");
    }

    @ApiOperation("查询商品列表")
    @GetMapping("/goodsList")
    public Result goodsList(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "1") int page) {
        Page current = goodsService.getGoodsList(page, size);
        Map map = Maps.newHashMap();
        map.put("page", current);
        return Result.createBySuccess(map);
    }
}
