package com.cp.controller;

import com.cp.domain.GoodsType;
import com.cp.service.BaseService;
import com.cp.service.GoodsTypeService;
import com.cp.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:35
 */
@RestController
@RequestMapping("/manage/goodsType")
public class GoodsTypeController extends BaseController<GoodsType, Long> {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Override
    protected BaseService<GoodsType, Long> getService() {
        return goodsTypeService;
    }

    @ApiOperation("删除类型")
    @GetMapping("/deleteType/{id}")
    public Result delete(@PathVariable String id) {
        goodsTypeService.updateStaById(id);
        return Result.createBySuccess("删除成功");
    }
}
