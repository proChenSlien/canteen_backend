package com.cp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用地址
 *
 * @author : lf
 * @Date : 2017/8/17 14:20
 */
@Api(description = "通用地址")
@RestController
public class IndexController {

//    @ApiOperation("初始页")
//    @GetMapping("/index")
//    public String index() {
//        return "index";
//    }

    @ApiOperation("主页")
    @GetMapping("/home")
    public String home() {
        return "home";
    }


}
