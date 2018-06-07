package com.cp.service.impl;

import com.cp.domain.ShoppingCar;
import com.cp.repository.ShoppingCarRepository;
import com.cp.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:38
 */
@Service
public class ShoppingCarServiceImpl extends AbstractGenericServiceImpl<ShoppingCar, Long> implements ShoppingCarService {
    @Autowired
    private ShoppingCarRepository repository;
    @Override
    public JpaRepository<ShoppingCar, Long> getRepository() {
        return repository;
    }
}
