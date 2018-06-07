package com.cp.api;

import com.cp.controller.BaseController;
import com.cp.domain.UserApi;
import com.cp.service.ApiUserService;
import com.cp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Slien
 * @Date: 2018-05-25 15:17
 */
@RestController
@RequestMapping("/api/system/userApi")
public class UserApiController extends BaseController<UserApi, Long> {
    @Autowired
    private ApiUserService apiUserService;
    @Override
    protected BaseService<UserApi, Long> getService() {
        return apiUserService;
    }
}
