package com.cp.controller;

import com.cp.domain.Address;
import com.cp.service.AddressService;
import com.cp.service.BaseService;
import com.cp.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-24 11:27
 */
@RestController
@RequestMapping("/manage/address")
public class AddressController extends BaseController<Address, Long> {

    @Autowired
    private AddressService addressService;
    @Override
    protected BaseService<Address, Long> getService() {
        return addressService;
    }

    @ApiOperation("删除商品")
    @GetMapping("/deleteAddress/{id}")
    public Result delete(@PathVariable String id) {
        addressService.updateStaById(id);
        return Result.createBySuccess("删除成功");
    }

    @ApiOperation("ces")
    @GetMapping("/d")
    public void d(@PathVariable Address id) {
        String m = "";
        System.out.print(id.getAddress());
    }
}
