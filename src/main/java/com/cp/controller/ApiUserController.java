package com.cp.controller;

import com.cp.domain.UserApi;
import com.cp.service.ApiUserService;
import com.cp.service.BaseService;
import com.cp.utils.PasswordHelper;
import com.cp.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Slien
 * @Date: 2018-05-24 10:19
 */
@RestController
@RequestMapping("/manage/apiUser")
public class ApiUserController extends BaseController<UserApi, Long>{

    @Autowired
    private ApiUserService apiUserService;
    @Override
    protected BaseService<UserApi, Long> getService() {
        return apiUserService;
    }

    @ApiOperation("更新用户")
    @Override
    @PostMapping("/merge")
    public Result saveOrUpdate(UserApi entity) {
        if (StringUtils.hasText(entity.getPassword())) {
            PasswordHelper.encryptPassword(entity);
        }

        this.getService().save(entity);
        return Result.createBySuccess("保存成功");
    }

    @ApiOperation("删除用户")
    @GetMapping("/deleteUser/{id}")
    public Result delete(@PathVariable String id) {
        apiUserService.updateStaById(id);
        return Result.createBySuccess("删除成功");
    }



}
