package com.cp.controller;

import com.cp.domain.Role;
import com.cp.service.BaseService;
import com.cp.service.RoleService;
import com.cp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author : lf
 * @Date : 2017/6/26 15:11
 */
@RestController
@RequestMapping("/manage/role")
public class RoleController extends BaseController<Role, Long> {

    @Autowired
    private RoleService roleService;

    @PostMapping("/auth")
    public Result auth(@RequestParam List<String> resourceIds, Long userId){
        roleService.correlateResource(resourceIds, userId);
        return Result.createBySuccess();
    }


    @Override
    protected BaseService getService() {
        return roleService;
    }
}
