package com.cp.controller;

import com.cp.domain.User;
import com.cp.service.BaseService;
import com.cp.service.UserService;
import com.cp.utils.PasswordHelper;
import com.cp.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : lf
 * @Date : 2017/6/26 15:11
 */
@RestController
@RequestMapping("/manage/user")
public class UserController extends BaseController<User, Long> {

    @Autowired
    private UserService userService;

    @ApiOperation("更新用户")
    @Override
    @PostMapping("/merge")
    public Result saveOrUpdate(User entity) {
        if (StringUtils.hasText(entity.getPassword())) {
            PasswordHelper.encryptPassword(entity);
        }

        this.getService().save(entity);
        return Result.createBySuccess("保存成功");
    }

    @PostMapping("/roles")
    public Result setUserRoles(@RequestParam List<Long> roleIds, @RequestParam Long userId) {
        userService.setUserRoles(roleIds, userId);
        return Result.createBySuccess();
    }

    @Override
    protected BaseService<User, Long> getService() {
        return userService;
    }
}
