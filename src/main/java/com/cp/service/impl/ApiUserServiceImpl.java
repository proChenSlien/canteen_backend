package com.cp.service.impl;

import com.cp.domain.UserApi;
import com.cp.repository.ApiUserRepository;
import com.cp.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author: Slien
 * @Date: 2018-05-24 10:34
 */
@Service
public class ApiUserServiceImpl extends AbstractGenericServiceImpl<UserApi, Long> implements ApiUserService {

    @Autowired
    private ApiUserRepository repository;

    @Override
    public JpaRepository<UserApi, Long> getRepository() {
        return repository;
    }


    @Override
    @Transactional
    public void updateStaById(String id) {
        repository.updateStaById(id);
    }
}
