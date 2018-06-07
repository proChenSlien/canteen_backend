package com.cp.service.impl;

import com.cp.domain.Role;
import com.cp.domain.User;
import com.cp.repository.RoleRepository;
import com.cp.repository.UserRepository;
import com.cp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : lf
 *
 * @Date : 2017/6/26 15:05
 */
@Service
public class UserServiceImpl extends AbstractGenericServiceImpl<User, Long> implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public JpaRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    public Page<User> findAll(int page, int size, User user) {
        PageRequest pageRequest = PageRequest.of(page, size);

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains()); //姓名采用 like 的方式查询

        Example<User> ex = Example.of(user, matcher);
        return repository.findAll(ex, pageRequest);
    }

    @Override
    public User findByUsername(String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public void setUserRoles(List<Long> roleIds, Long userId) {
        User user = repository.getOne(userId);
        List<Role> roles = roleRepository.findAllById(roleIds);
        user.setRoles(roles);
        repository.save(user);
    }
}
