package com.cp.service;

import com.cp.domain.Role;

import java.util.List;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/7/28 15:17
 */
public interface RoleService extends BaseService<Role, Long> {

    /**
     * TODO 关联资源
     * @auther: liufeng
     * @Date: 2017/10/26 17:29
     */
    void correlateResource(List<String> resourceId, Long userId);
}
