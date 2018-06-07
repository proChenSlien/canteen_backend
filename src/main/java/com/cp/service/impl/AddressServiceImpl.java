package com.cp.service.impl;

import com.cp.domain.Address;
import com.cp.repository.AddressRepository;
import com.cp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author: Slien
 * @Date: 2018-05-24 11:32
 */
@Service
public class AddressServiceImpl extends AbstractGenericServiceImpl<Address, Long> implements AddressService {
    @Autowired
    private AddressRepository repository;
    @Override
    public JpaRepository<Address, Long> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void updateStaById(String id) {
        repository.updateStaById(id);
    }
}
