package com.cp.service.impl;

import com.cp.domain.Order;
import com.cp.repository.OrderRepository;
import com.cp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:27
 */
@Service
public class OrderServiceImpl extends AbstractGenericServiceImpl<Order, Long> implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Override
    public JpaRepository<Order, Long> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void updateStaById(String id) {
        repository.updateStaById(id);
    }
}
