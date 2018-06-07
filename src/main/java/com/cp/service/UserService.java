package com.cp.service;

import com.cp.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author : lf
 *
 * @Date : 2017/6/26 15:04
 */
public interface UserService extends BaseService<User, Long> {

    Page<User> findAll(int page, int size, User user);

    User findByUsername(String userName);

    void setUserRoles(List<Long> roleIds, Long userId);
}
