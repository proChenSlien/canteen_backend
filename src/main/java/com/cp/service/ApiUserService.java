package com.cp.service;

import com.cp.domain.UserApi;

/**
 * @author: Slien
 * @Date: 2018-05-24 10:25
 */
public interface ApiUserService extends BaseService<UserApi, Long> {
    void updateStaById(String id);
}
